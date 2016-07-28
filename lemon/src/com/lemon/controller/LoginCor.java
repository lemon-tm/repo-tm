package com.lemon.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

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
import com.lemon.constant.font.enums.ImgCategoryEnum;
import com.lemon.entity.Img;
import com.lemon.entity.ImgMsg;
import com.lemon.entity.LemonUser;
import com.lemon.service.ImgMsgService;
import com.lemon.service.ImgService;
import com.lemon.service.LemonUserService;
import com.lemon.service.PropertiesService;
import com.lemon.util.FrontUtils;
import com.lemon.util.Pager;
import com.lemon.util.ResponseUtils;
import com.lemon.util.encoder.PwdEncoder;

@Controller
public class LoginCor {

	@Resource
	private LemonUserService lemonUserService ;
	
	@Resource
	private ImgService imgService ;
	
	@Resource
	private ImgMsgService imgMsgService ;
	
	@Resource
	private PwdEncoder pwdEncoder;

	@Resource
	private PropertiesService propertiesService ;
	
	/**
	 * hhc add 2016-04-08 14:24
	 * 
	 * 登出
	 * @throws IOException 
	 * @throws ServletException 
	 * 
	 * */
	@RequestMapping(value="/logout.jspx", method = RequestMethod.GET)
	public void logout(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws ServletException, IOException{
		FrontUtils.frontData(request, model , propertiesService) ;
		
		request.getSession().removeAttribute("user") ;
		request.getRequestDispatcher("/home.jspx").forward(request, response) ;
		
		
	}
	
	/**
	 * 2016-05-11 10:24 hhc add
	 * 
	 *  用于判断用户名是否已经被注册
	 * 
	 */
	@RequestMapping(value="/checkUser.jspx", method = RequestMethod.POST)
	public void checkUserName(String username,HttpServletRequest request, HttpServletResponse response, ModelMap model) throws ServletException, IOException{
		FrontUtils.frontData(request, model , propertiesService) ;
		
		LemonUser user = new LemonUser() ;
		user.setUsername(username) ;
		user = lemonUserService.getUser(user) ;
		if(null!=user){
			ResponseUtils.renderJson(response, "true");
		}else{
			ResponseUtils.renderJson(response, "false");
		}
		
	}
	
	@RequestMapping(value="/register.jspx", method = RequestMethod.POST)
	public String register(LemonUser user, String username,String password, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws UnsupportedEncodingException, MessagingException{
		FrontUtils.frontData(request, model , propertiesService) ;
		LemonUser isUser = lemonUserService.findLemonUser(user) ;
		if(null==isUser){
			user.setPassword(pwdEncoder.encodePassword(password)) ;
			lemonUserService.save(user) ;
			request.getSession().setAttribute("user", user) ;
			
			//发送邮件给我，配置文件位置email.properties
			EmailSend emailSend =  new EmailSend();
			String html = "用户名："+user.getUsername()+"<br/>邮箱："+user.getEmail();
			emailSend.send("rlemon新用户注册提示邮件",html ,null);
			
		}else{
			request.getSession().setAttribute("user", isUser) ;
		}
		//返回位置错误，应有注册成功等待邮箱验证页面
		return "/WEB-INF/jsp/index.jsp" ;
	}
	
	@RequestMapping(value="/to_register.jspx", method = RequestMethod.GET)
	public String toRegister(HttpServletRequest request, HttpServletResponse response, ModelMap model){
		FrontUtils.frontData(request, model , propertiesService) ;
		return "/WEB-INF/jsp/register.jsp" ;
	}
	
	@RequestMapping(value="/login.jspx", method = RequestMethod.GET)
	public String view(HttpServletRequest request, HttpServletResponse response, ModelMap model){
		FrontUtils.frontData(request, model , propertiesService) ;
		model.put("to", "test") ;
		return "/WEB-INF/jsp/login.jsp" ;
	}
	
	@RequestMapping(value="/login.jspx", method=RequestMethod.POST)
	public void index(String username, String password, 
			HttpServletRequest request, HttpServletResponse response, ModelMap model){
		FrontUtils.frontData(request, model , propertiesService) ;
		LemonUser user = new LemonUser() ;
		user.setUsername(username) ;
		user.setPassword(pwdEncoder.encodePassword(password)) ;
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
	@RequestMapping(value="/home.jspx", method={RequestMethod.GET,RequestMethod.POST})
	public String gethome(String keywords, Pager pager, HttpServletRequest request, HttpServletResponse response, ModelMap model){
		LemonUser user = (LemonUser) request.getSession().getAttribute("user") ;
		pager.setPageSize(30) ;
		FrontUtils.frontData(request, model , propertiesService) ;

		List<ImgMsg> list = imgMsgService.getList() ;
		for(ImgMsg i:list){
			if(null!=i){
				Img img = new Img() ;
				img.setRelationId(i.getId()) ;
				List<Img> imglist = imgService.getListBy(img) ;//根据父级id查找列表
				i.setImglist(imglist) ;
			}
		}
		
		
		ImgCategoryEnum[] ary = ImgCategoryEnum.values() ;
		model.put("list", list) ;
		model.put("imgcategoryary", ary) ;
		model.put("pager", pager) ;
		model.put("user", user) ;
		model.put("keywords", keywords) ;
		return "/WEB-INF/jsp/index.jsp" ;
	}
	/**
	 *  hhc add 2016-07-21
	 * 
	 *  前台滚动图片获取文字信息
	 *  
	 *  ajax
	 * 
	 */
	@RequestMapping(value="/scroll_imgmsg.jspx", method=RequestMethod.POST)
	public void scrollImgMsg(String imgId, 
			HttpServletRequest request, HttpServletResponse response, ModelMap model){
		FrontUtils.frontData(request, model , propertiesService) ;
		
		ImgMsg msg = new ImgMsg() ;
		if(null!=imgId){
			Img img = imgService.get(imgId) ;
			if(null!=img){
				msg = imgMsgService.get(img.getRelationId()) ;
				if(null!=msg && msg.getUserId().length()>0){
					LemonUser user = lemonUserService.get(msg.getUserId()) ;
					msg.setUser(user) ;
				}
			}
		}
		
		
		
		
		JSONObject json = new JSONObject();
		
		json.put("name", msg.getName()) ;
		json.put("describes", msg.getDescribes()) ;
		json.put("createTime", msg.getCreateTime()) ;
		if(null!=msg.getUser()){
			json.put("trueName", msg.getUser().getTrueName()) ;
		}
		
		ResponseUtils.renderJson(response, json.toString());
		
	}
	
	
	
	/**
	 * imgId,图片滚动,有值时认为是图片滚动， 否则瀑布流
	 * 
	 */
	@RequestMapping(value="/photograph.jspx", method={RequestMethod.GET,RequestMethod.POST})
	public String phpto(String index,String imgId, String category, String keywords, Pager pager, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws UnsupportedEncodingException{
		LemonUser user = (LemonUser) request.getSession().getAttribute("user") ;
		pager.setPageSize(100) ;
		FrontUtils.frontData(request, model , propertiesService) ;

		if(null!=keywords && null!=imgId){
			keywords = new String(keywords.getBytes("ISO-8859-1"),"UTF-8");
			model.put("keywords", keywords) ;
		}
		
		pager = imgService.getList(pager, keywords, category) ;
		List<Img> list = (List<Img>) pager.getResult() ; 
		for(Img i:list){
			if(null!=i && null!=i.getRelationId() && i.getRelationId().length()>0){
				ImgMsg msg = imgMsgService.get(i.getRelationId()) ;
				if(null!=msg && msg.getUserId().length()>0){
					LemonUser u = lemonUserService.get(msg.getUserId()) ;
					i.setTrueName(u.getTrueName()) ;
				}
				i.setName(msg.getName()) ;
				i.setDescribes(msg.getDescribes()) ;
				i.setCreateTime(msg.getCreateTime()) ;
			}
		}
		
		model.put("pager", pager) ;
		model.put("user", user) ;
		model.put("category", category) ;
		model.put("keywords", keywords) ;
		model.put("imgId", imgId) ;
		if(null!=imgId){
			model.put("index", index) ;
			return "/WEB-INF/jsp/scrollshowimg.jsp" ;
		}
		return "/WEB-INF/jsp/index_photo.jsp" ;
	}
	
}
