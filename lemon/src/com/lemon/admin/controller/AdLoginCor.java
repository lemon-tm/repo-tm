package com.lemon.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lemon.admin.service.AdImgService;
import com.lemon.admin.service.AdLemonUserService;
import com.lemon.constant.font.enums.VerifyEnum;
import com.lemon.entity.ImgHouse;
import com.lemon.entity.LemonUser;
import com.lemon.util.FrontUtils;
import com.lemon.util.Pager;
import com.lemon.util.ResponseUtils;

@Controller
public class AdLoginCor {
	@Resource
	private AdImgService adImgService ;
	
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
		ImgHouse img = new ImgHouse() ;

		pager = adImgService.getList(pager, user, img) ;
		List<ImgHouse> imglist = (List<ImgHouse>) pager.getResult() ;
		for(ImgHouse i:imglist){
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
	public String showImglist(String imgId, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws ServletException, IOException{
		FrontUtils.frontData(request, model);
		LemonUser user = (LemonUser) request.getSession().getAttribute("user") ;

		ImgHouse img = adImgService.get(imgId) ;
		
		model.put("user", user) ;
		model.put("img", img) ;
		return "/WEB-INF/jsp/admin/ashowimg.jsp" ;
	}

	/**
	 * hhc add 2016-04-11 16:35
	 * 审核图片
	 * */
	@RequestMapping(value="/ucenter/isverify.do", method = RequestMethod.POST)
	public void isverify(String imgId, Integer verify, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws ServletException, IOException{
		FrontUtils.frontData(request, model);
		LemonUser user = (LemonUser) request.getSession().getAttribute("user") ;

		ImgHouse img = adImgService.get(imgId) ;
		if(null!=img){
			img.setIsverify(VerifyEnum.getVerifyEnum(verify)) ;
		}
		adImgService.saveOrUpdate(img) ;
		JSONObject json = new JSONObject();
		json.put("verify", img.getIsverify());
		ResponseUtils.renderJson(response, json.toString());
	}
}
