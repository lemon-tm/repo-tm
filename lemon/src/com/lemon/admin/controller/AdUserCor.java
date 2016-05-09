package com.lemon.admin.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lemon.admin.service.AdLemonUserService;
import com.lemon.entity.ImgHouse;
import com.lemon.entity.LemonUser;
import com.lemon.util.FrontUtils;
import com.lemon.util.Pager;

@Controller
public class AdUserCor {

	@Resource
	private AdLemonUserService userService ;
	/**
	 * hhc add 2016-05-09
	 * 后台管理，用户列表 
	 * 
	 */
	@RequestMapping(value="/ucenter/userlist.do", method=RequestMethod.GET)
	public String getUserList(Pager pager, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		FrontUtils.frontData(request, model);
		LemonUser user = (LemonUser) request.getSession().getAttribute("user") ;

		pager = userService.getList(pager) ;
		
		model.put("user", user) ;
		model.put("pager", pager) ;
		return "/WEB-INF/jsp/admin/userlist.jsp" ;
	}
}
