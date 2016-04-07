package com.lemon.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lemon.entity.LemonUser;
import com.lemon.service.ImgHouseService;
import com.lemon.service.LemonUserService;
import com.lemon.util.FrontUtils;
import com.lemon.util.Pager;
import com.lemon.util.ResponseUtils;

@Controller
public class LoginCor {

	@Resource
	private LemonUserService lemonUserService ;
	@Resource
	private ImgHouseService imgHouseService ;
	/**
	 * 
	 * 用于测试权限，可删除
	 * */
	@RequestMapping(value="/user/register.jspx", method = RequestMethod.GET)
	public String register_test(LemonUser user, String username,String password, HttpServletRequest request, HttpServletResponse response, ModelMap model){
		FrontUtils.frontData(request, model);
		LemonUser isUser = lemonUserService.findLemonUser(user) ;
		if(null==isUser){
			lemonUserService.save(user) ;
//			model.put("user", user) ;
			request.getSession().setAttribute("user", user) ;
		}else{
			request.getSession().setAttribute("user", isUser) ;
		}
		return "/WEB-INF/jsp/index.jsp" ;
	}
	
	
	@RequestMapping(value="/register.jspx", method = RequestMethod.POST)
	public String register(LemonUser user, String username,String password, HttpServletRequest request, HttpServletResponse response, ModelMap model){
		FrontUtils.frontData(request, model);
		LemonUser isUser = lemonUserService.findLemonUser(user) ;
		if(null==isUser){
			lemonUserService.save(user) ;
//			model.put("user", user) ;
			request.getSession().setAttribute("user", user) ;
		}else{
			request.getSession().setAttribute("user", isUser) ;
		}
		return "/WEB-INF/jsp/index.jsp" ;
	}
	
	@RequestMapping(value="/to_register.jspx", method = RequestMethod.GET)
	public String toRegister(HttpServletRequest request, HttpServletResponse response, ModelMap model){
		FrontUtils.frontData(request, model);
		return "/WEB-INF/jsp/register.jsp" ;
	}
	
	@RequestMapping(value="/login.jspx", method = RequestMethod.GET)
	public String view(HttpServletRequest request, HttpServletResponse response, ModelMap model){
		FrontUtils.frontData(request, model);
		model.put("to", "test") ;
		return "/WEB-INF/jsp/login.jsp" ;
	}
	
	@RequestMapping(value="/login.jspx", method=RequestMethod.POST)
	public void index(String username, String password, 
			HttpServletRequest request, HttpServletResponse response, ModelMap model){
		FrontUtils.frontData(request, model);
		LemonUser user = new LemonUser() ;
		user.setUsername(username) ;
		user.setPassword(password) ;
		LemonUser isUser = lemonUserService.findLemonUser(user) ;
		JSONObject json = new JSONObject();
		if(isUser!=null){
			json.put("message", true);
			request.getSession().setMaxInactiveInterval(18*1000);
			request.getSession().setAttribute("user", isUser) ;
		}else{
			json.put("message", false);
		}
		ResponseUtils.renderJson(response, json.toString());
		
	}
	@RequestMapping(value="/home.jspx", method=RequestMethod.GET)
	public String home(Pager pager, HttpServletRequest request, HttpServletResponse response, ModelMap model){
		LemonUser user = (LemonUser) request.getSession().getAttribute("user") ;
		String pUrl = request.getServletPath() ;
		pager.setpUrl(pUrl) ;
		FrontUtils.frontData(request, model) ;
		pager = imgHouseService.getList(pager) ;
		
		model.put("pager", pager) ;
		model.put("user", user) ;
		return "/WEB-INF/jsp/index.jsp" ;
	}
}
