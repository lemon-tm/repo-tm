package com.lemon.controller;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lemon.common.service.ImageService;
import com.lemon.constant.font.enums.ImgStatusEnum;
import com.lemon.constant.font.enums.MsgStatesEnum;
import com.lemon.entity.ImgHouse;
import com.lemon.entity.LemonUser;
import com.lemon.entity.Message;
import com.lemon.service.ImgHouseService;
import com.lemon.service.MessageService;
import com.lemon.util.FrontUtils;
import com.lemon.util.Pager;

@Controller
public class MessageCor{
	
	@Resource
	private MessageService messageService ;
	
	/**
	 * 
	 * 2016-5-17 22:38
	 * 
	 * 用户中心查看自己的留言
	 * 
	 * 
	 **/
	
	@RequestMapping(value="/ucenter/msglist.jspx", method=RequestMethod.GET)
	public String uImglist(Pager page, HttpServletRequest request, HttpServletResponse response, ModelMap model){
		FrontUtils.frontData(request, model);
		LemonUser user = (LemonUser) request.getSession().getAttribute("user") ;
		
		Message msg = new Message() ; 
		
		if(null!=user){
			
			msg.setUserId(user.getId()) ;
			page = messageService.getMsgList(page, msg ) ;
			
		}
		model.put("pager", page) ;
		
		return "/WEB-INF/jsp/ucenter/msglist.jsp" ;
	}
	
	
	
	/**
	 * hhc add 2016-05-16 15:39
	 * 
	 * 跳转--留言页面
	 * 
	 * */
	@RequestMapping(value="/leave-message.jspx", method = RequestMethod.GET)
	public String toSave(HttpServletRequest request,HttpServletResponse response, ModelMap model){
		FrontUtils.frontData(request, model);
		LemonUser user = (LemonUser) request.getSession().getAttribute("user") ;
		if(null!=user && !"".equals(user)){
			model.put("username", user.getUsername()) ;
			model.put("email", user.getEmail()) ;
		}
		
		model.put("imgHouse", "") ;
		return "/WEB-INF/jsp/msg/leave-msg.jsp" ;
	}
	/**
	 * hhc add 2016-05-17 17:13
	 * 
	 * 保存留言
	 * @throws IOException 
	 * @throws ServletException 
	 * 
	 * */
	@RequestMapping(value="/savemsg.jspx", method = RequestMethod.POST)
	public String save(Message message, HttpServletRequest request,HttpServletResponse response, ModelMap model) throws ServletException, IOException{
		FrontUtils.frontData(request, model);
		LemonUser user = (LemonUser) request.getSession().getAttribute("user") ;
		if(null!=user){
			message.setUserId(user.getId()) ;
		}
		message.setStates(MsgStatesEnum.getMsgStatesEnum(0)) ;
		message.setCreateTime(new Date()) ;
		messageService.save(message) ;

		request.getRequestDispatcher("/home.jspx").forward(request, response) ;
		return null ;
	}
	
}
