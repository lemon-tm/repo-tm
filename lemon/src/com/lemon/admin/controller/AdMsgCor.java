package com.lemon.admin.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lemon.admin.service.AdLemonUserService;
import com.lemon.admin.service.AdMessageService;
import com.lemon.common.email.EmailSend;
import com.lemon.constant.font.enums.MsgStatesEnum;
import com.lemon.entity.LemonUser;
import com.lemon.entity.Message;
import com.lemon.util.FrontUtils;
import com.lemon.util.Pager;

@Controller
public class AdMsgCor {

	@Resource
	private AdMessageService adMessageService ;
	
	@Resource
	private AdLemonUserService userService ;
	
	
	
	
	/**
	 * hhc add 2016-05-19 11:53
	 * 
	 * 后台管理，邮件回复
	 * @throws MessagingException 
	 * 
	 */
	@RequestMapping(value="/ucenter/replyemail.do", method=RequestMethod.POST)
	public String reply(Message msgr, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws MessagingException {
		FrontUtils.frontData(request, model);
		LemonUser user = (LemonUser) request.getSession().getAttribute("user") ;

		Message msg = adMessageService.get(msgr.getId()) ;
		
		if(null!=msg && msg.getStates().getValue()<2){
			msg.setReplyContent(msgr.getReplyContent()) ;
			msg.setStates(MsgStatesEnum.getMsgStatesEnum(2)) ;
			msg.setReplayTime(new Date()) ;
			adMessageService.update(msg) ;
			
			//发送邮件给我，配置文件位置email.properties
			EmailSend emailSend =  new EmailSend();
			String html = msgr.getReplyContent() ;
			String toEmail = msgr.getEmail() ;
			emailSend.send("rlemon回复了您的留言",html,toEmail);
			model.put("message", "回复成功，已发送邮件！") ;
		}
		
		model.put("user", user) ;
		model.put("msg", msg) ;
		
		return "/WEB-INF/jsp/admin/message/showmsg.jsp" ;
	}
	
	
	/**
	 * hhc add 2016-05-19 11:27
	 * 
	 * 后台管理，查看留言
	 * 
	 */
	@RequestMapping(value="/ucenter/showmsg.do", method=RequestMethod.GET)
	public String showMsg(String msgId, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		FrontUtils.frontData(request, model);
		LemonUser user = (LemonUser) request.getSession().getAttribute("user") ;

		Message msg = adMessageService.get(msgId) ;
		if(null!=msg && msg.getStates().getValue()==0){
			msg.setStates(MsgStatesEnum.getMsgStatesEnum(1)) ;
			msg.setReadTime(new Date()) ;
			adMessageService.update(msg) ;
		}
		model.put("user", user) ;
		model.put("msg", msg) ;
		
		return "/WEB-INF/jsp/admin/message/showmsg.jsp" ;
	}
	/**
	 * hhc add 2016-05-19 10:49
	 * 
	 * 后台管理，留言列表 
	 * 
	 */
	@RequestMapping(value="/ucenter/msglist.do", method=RequestMethod.GET)
	public String getMsgList(Pager pager, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		FrontUtils.frontData(request, model);
		LemonUser user = (LemonUser) request.getSession().getAttribute("user") ;

		pager = adMessageService.getList(pager) ;
		List<Message> list = (List<Message>) pager.getResult() ;
		for(Message msg:list){
			if(null!=msg.getUserId() && !"".equals(msg.getUserId())){
				LemonUser u = userService.get(msg.getUserId()) ;
				if(null!=u){
					msg.setUsername(u.getUsername()) ;
				}
			}
		}
		
		model.put("user", user) ;
		model.put("pager", pager) ;
		return "/WEB-INF/jsp/admin/message/msglist.jsp" ;
	}
}
