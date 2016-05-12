package com.lemon.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lemon.common.email.EmailSend;
import com.lemon.entity.LemonUser;
import com.lemon.service.ImgHouseService;
import com.lemon.service.LemonUserService;
import com.lemon.util.FrontUtils;
import com.lemon.util.Pager;
import com.lemon.util.ResponseUtils;
import com.lemon.util.encoder.PwdEncoder;

@Controller
public class SetUpUserCor {

	@Resource
	private LemonUserService lemonUserService ;
	

	/**
	 * hhc add 2016-05-12 11:29
	 * 
	 * 用户基本信息设置 
	 * Basic information 
	 * 
	 * */
	@RequestMapping(value="/ucenter/setUpUser.jspx", method = RequestMethod.GET)
	public String basicInformation(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws ServletException, IOException{
		FrontUtils.frontData(request, model);
		
		return "/WEB-INF/jsp/ucenter/basicinformation.jsp" ;
	}
	/**
	 * hhc add 2016-05-12 13：39
	 * 保存
	 * 用户基本信息设置 
	 * Basic information 
	 * 
	 * */
	@RequestMapping(value="/ucenter/saveUser.jspx", method = RequestMethod.POST)
	public String saveBasicInformation(LemonUser user, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws ServletException, IOException{
		FrontUtils.frontData(request, model);
		LemonUser this_user = (LemonUser) request.getSession().getAttribute("user") ;
		
		this_user.setTrueName(user.getTrueName()) ;
		this_user.setCellPhone(user.getCellPhone()) ;
		this_user.setWeixin(user.getWeixin()) ;
		this_user.setQq(user.getQq()) ;
		
		lemonUserService.update(this_user) ;
		
		model.put("save", true) ;
		return "/WEB-INF/jsp/ucenter/basicinformation.jsp" ;
	}
	
	
}
