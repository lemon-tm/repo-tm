package com.lemon.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lemon.entity.ImgHouse;
import com.lemon.entity.LemonUser;
import com.lemon.service.ImgHouseService;
import com.lemon.service.LemonUserService;
import com.lemon.util.FrontUtils;

@Controller
public class ImgCor {

	@Resource
	private ImgHouseService imgHouseService ;
	@Resource
	private LemonUserService lemonUserService ;
	
	@RequestMapping(value="/imgshow.jspx", method=RequestMethod.GET)
	public String toImg(String index, String imgId, HttpServletRequest request, HttpServletResponse response, ModelMap model){
		FrontUtils.frontData(request, model);
		LemonUser user = (LemonUser) request.getSession().getAttribute("user") ;
		ImgHouse img = null ;
		if(null!=imgId && !"".equals(imgId)){
			img = imgHouseService.get(imgId) ;
		}
		
		if(null!=img){
			user = lemonUserService.get(img.getUserId()) ;
			img.setUser(user) ;
		}
		model.put("img", img) ;
		model.put("index", index) ;
		return "/WEB-INF/jsp/showimg.jsp" ;
	}

}
