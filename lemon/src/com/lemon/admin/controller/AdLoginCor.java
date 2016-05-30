package com.lemon.admin.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lemon.admin.service.AdImgMsgService;
import com.lemon.admin.service.AdImgService;
import com.lemon.admin.service.AdLemonUserService;
import com.lemon.constant.font.enums.VerifyEnum;
import com.lemon.entity.Img;
import com.lemon.entity.ImgHouse;
import com.lemon.entity.ImgMsg;
import com.lemon.entity.LemonUser;
import com.lemon.util.FrontUtils;
import com.lemon.util.Pager;
import com.lemon.util.ResponseUtils;

@Controller
public class AdLoginCor {
	@Resource
	private AdImgService adImgService ;
	
	@Resource
	private AdImgMsgService adImgMsgService ;
	
	@Resource
	private AdLemonUserService adLemonUserService ;
	
	
	/**
	 * hhc add 2016-04-11 10:11
	 * 后台首页
	 * */
	@RequestMapping(value="/ucenter/index.do", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws ServletException, IOException{
		FrontUtils.frontData(request, model);
		LemonUser user = (LemonUser) request.getSession().getAttribute("user") ;
		model.put("user", user) ;
		return "/WEB-INF/jsp/admin/index.jsp" ;
	}
	
	/**
	 * hhc add 2016-04-11 11：01
	 * 图片列表
	 * */
	@RequestMapping(value="/ucenter/imglist.do", method = RequestMethod.GET)
	public String imglist(Pager pager, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws ServletException, IOException{
		FrontUtils.frontData(request, model);
		LemonUser user = (LemonUser) request.getSession().getAttribute("user") ;
		Img img = new Img() ;
		ImgMsg imgmsg = new ImgMsg() ;
		
		pager = adImgMsgService.getList(pager, user, img) ;
		List<ImgMsg> imgmsglist = (List<ImgMsg>) pager.getResult() ;
		for(ImgMsg i:imgmsglist){
			if(null!=i){
				img.setRelationId(i.getId()) ;
				List<Img> imglist = adImgService.getListBy(img) ;//根据父级id查找列表
				i.setImglist(imglist) ;
			}
			
			LemonUser u = adLemonUserService.get(i.getUserId()) ;
			i.setUser(u) ;
		}
		
		model.put("user", user) ;
		model.put("pager", pager) ;
		return "/WEB-INF/jsp/admin/imglist.jsp" ;
	}
	
	/**
	 * hhc add 2016-05-06 15:25
	 * 
	 * 查看详细图片列表
	 * */
	@RequestMapping(value="/ucenter/showImglist.do", method = RequestMethod.GET)
	public String showImglist(String index, String imgId, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws ServletException, IOException{
		FrontUtils.frontData(request, model);
		LemonUser user = (LemonUser) request.getSession().getAttribute("user") ;
		ImgMsg imgmsg = null ;
		if(null!=imgId && !"".equals(imgId)){
			imgmsg = adImgMsgService.get(imgId) ;
			if(null!=imgmsg){
				Img img = new Img() ;
				img.setRelationId(imgmsg.getId()) ;
				List<Img> imglist = adImgService.getListBy(img) ;//根据父级id查找列表
				imgmsg.setImglist(imglist) ;
			}
			
			user = adLemonUserService.get(imgmsg.getUserId()) ;
			imgmsg.setUser(user) ;
		}
		if(null==index || index.length()<0){
			index="0" ;
		}
		
		model.put("img", imgmsg) ;
		model.put("index", index) ;
		return "/WEB-INF/jsp/admin/ashowimg.jsp" ;
	}

	
	
	
	/**
	 * hhc add 2016-04-11 16:35
	 * 
	 * 单个审核图片
	 * 参数
	 * imgId，是Img的id
	 * */
	@Transactional
	@RequestMapping(value="/ucenter/isverifyimg.do", method = RequestMethod.POST)
	public void isverifyimg(String imgId, Integer verify, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws ServletException, IOException{
		FrontUtils.frontData(request, model);
		LemonUser user = (LemonUser) request.getSession().getAttribute("user") ;
		Img img = adImgService.get(imgId) ;
		if(null!=img){
			img.setIsverify(VerifyEnum.getVerifyEnum(verify)) ;
			img.setVerifyTime(new Date()) ;
			adImgService.update(img) ;
			
			JSONObject json = new JSONObject();
			if(verify==1){
				json.put("verify", true);
			}else{
				json.put("verify", false);
			}
			ResponseUtils.renderJson(response, json.toString());
		}
	}
	/**
	 * hhc add 2016-04-11 16:35
	 * 
	 * 批量审核审核图片
	 * 参数
	 * imgId，是ImgMsg的id
	 * */
	@Transactional
	@RequestMapping(value="/ucenter/isverify.do", method = RequestMethod.POST)
	public void isverify(String imgId, Integer verify, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws ServletException, IOException{
		FrontUtils.frontData(request, model);
		LemonUser user = (LemonUser) request.getSession().getAttribute("user") ;
		Img img = new Img() ;
		img.setRelationId(imgId) ;
		List<Img> imglist = adImgService.getListBy(img) ;
		for(Img i:imglist){
			if(null!=i){
				i.setIsverify(VerifyEnum.getVerifyEnum(verify)) ;
				i.setVerifyTime(new Date()) ;
			}
			adImgService.update(i) ;
		}
		JSONObject json = new JSONObject();
		if(verify==1){
			json.put("verify", true);
		}else{
			json.put("verify", false);
		}
		ResponseUtils.renderJson(response, json.toString());
	}
}
