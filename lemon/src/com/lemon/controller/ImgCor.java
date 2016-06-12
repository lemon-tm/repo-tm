package com.lemon.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lemon.constant.font.enums.ImgStatusEnum;
import com.lemon.entity.Img;
import com.lemon.entity.ImgHouse;
import com.lemon.entity.ImgMsg;
import com.lemon.entity.LemonUser;
import com.lemon.service.ImgHouseService;
import com.lemon.service.ImgMsgService;
import com.lemon.service.ImgService;
import com.lemon.service.LemonUserService;
import com.lemon.service.PropertiesService;
import com.lemon.util.FrontUtils;

@Controller
public class ImgCor {

	@Resource
	private ImgHouseService imgHouseService ;
	@Resource
	private LemonUserService lemonUserService ;
	
	
	@Resource
	private ImgService imgService ;
	
	@Resource
	private ImgMsgService imgMsgService ;
	
	@Resource
	private PropertiesService propertiesService ;
	
	
	/**
	 * 2016-04-26 hhc 添加备注
	 * 用于首页使用
	 * 查看大图
	 * @throws UnsupportedEncodingException 
	 * 
	 **/
	@RequestMapping(value="/imgshow.jspx", method={RequestMethod.GET,RequestMethod.POST})
	public String toImg(String category, String keywords, String imgId, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws UnsupportedEncodingException{
		FrontUtils.frontData(request, model , propertiesService);
		LemonUser user = (LemonUser) request.getSession().getAttribute("user") ;
		Img img = null ;
		ImgMsg imgmsg = null ;
		if(null!=imgId && !"".equals(imgId)){
			img = imgService.get(imgId) ;
		}
		
		if(null!=img){
			imgmsg = imgMsgService.get(img.getRelationId()) ;
			if(null!=imgmsg && imgmsg.getUserId().length()>0){
				user = lemonUserService.get(imgmsg.getUserId()) ;
				imgmsg.setUser(user) ;
			}
		}
		model.put("img", img) ;
		model.put("imgmsg", imgmsg) ;
		if(null!=keywords){
			keywords = new String(keywords.getBytes("ISO-8859-1"),"UTF-8");
			model.put("keywords", keywords) ;
		}
		if(null!=category){
			model.put("category", category) ;
		}
		return "/WEB-INF/jsp/showimg.jsp" ;
	}
	
	/**
	 * 2016-04-26 hhc add
	 * 用于用户中心使用
	 * 查看大图
	 * 
	 **/
	@RequestMapping(value="/ucenter/uimgshow.jspx", method=RequestMethod.GET)
	public String toUcenterImg(String index, String imgId, HttpServletRequest request, HttpServletResponse response, ModelMap model){
		FrontUtils.frontData(request, model , propertiesService);
		LemonUser user = (LemonUser) request.getSession().getAttribute("user") ;
		ImgMsg img = null ;
		if(null!=imgId && !"".equals(imgId)){
			img = imgMsgService.get(imgId) ;
			if(null!=img){
				List<Img> imglist = imgService.getListBy(img.getId()) ;//根据父级id查找列表
				img.setImglist(imglist) ;
			}
			
			user = lemonUserService.get(img.getUserId()) ;
			img.setUser(user) ;
		}
		
		model.put("img", img) ;
		model.put("index", index) ;
		return "/WEB-INF/jsp/ucenter/ushowimg.jsp" ;
	}
	
	/**
	 * hhc add 2016-05-16 12:58
	 * 
	 * 用户删除列表中图片，按次删除
	 * @throws IOException 
	 * @throws ServletException 
	 * 
	 **/
	@RequestMapping(value="/ucenter/deleteImg.jspx", method=RequestMethod.GET)
	public void deleteImg(String imgId, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws ServletException, IOException{
		FrontUtils.frontData(request, model , propertiesService);
		ImgHouse img = null ;
		if(null!=imgId && !"".equals(imgId)){
			img = imgHouseService.get(imgId) ;
		}
		if(null!=img){
			img.setStatus(ImgStatusEnum.getImgStatusEnum(2)) ;
		}
		
		request.getRequestDispatcher("/ucenter/imglist.jspx").forward(request, response) ;
	}

}
