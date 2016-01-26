package com.lemon.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lemon.entity.LemonUser;
import com.lemon.service.ImgHouseService;
import com.lemon.util.FrontUtils;
import com.lemon.util.Pager;

@Controller
public class UCenterCor {

	@Resource
	private ImgHouseService imgHouseService ;
	
	@RequestMapping(value="/ucenter/imglist.jspx", method=RequestMethod.GET)
	public String uImglist(Pager page, HttpServletRequest request, HttpServletResponse response, ModelMap model){
		FrontUtils.frontData(request, model);
		LemonUser user = (LemonUser) request.getSession().getAttribute("user") ;

		if(null!=user){
			page = imgHouseService.findByUser(page, user.getId()) ;
		}
		model.put("page", page) ;
		
		return "/WEB-INF/jsp/ucenter/imglist.jsp" ;
	}
	
	@RequestMapping(value="/ucenter/upload.jspx", method=RequestMethod.GET)
	public String viewUpload(HttpServletRequest request, HttpServletResponse response, ModelMap model){
		FrontUtils.frontData(request, model);

		return "/WEB-INF/jsp/ucenter/upload.jsp" ;
	}
	@RequestMapping(value="/ucenter/index.jspx", method=RequestMethod.GET)
	public String home(HttpServletRequest request, HttpServletResponse response, ModelMap model){
		FrontUtils.frontData(request, model);
		LemonUser user = (LemonUser) request.getSession().getAttribute("user") ;
		return "/WEB-INF/jsp/ucenter/index.jsp" ;
	}
}
