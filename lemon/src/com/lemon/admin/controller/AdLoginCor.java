package com.lemon.admin.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
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
public class AdLoginCor {
	@Resource
	private ImgHouseService imgHouseService ;
	
	
	
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
		
		imgHouseService.findByUser(pager,null) ;
		
		
		model.put("user", user) ;
		return "/WEB-INF/jsp/admin/index.jsp" ;
	}
}
