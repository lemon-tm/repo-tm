package com.lemon.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
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
import com.lemon.util.FrontUtils;
import com.lemon.util.Pager;

@Controller
public class UCenterCor {

	@Resource
	private ImgHouseService imgHouseService ;
	@Resource
	private ImgService imgService ;
	@Resource
	private ImgMsgService imgMsgService ;
	
	
	
	@RequestMapping(value="/ucenter/imglist.jspx", method=RequestMethod.GET)
	public String uImglist(Pager page, HttpServletRequest request, HttpServletResponse response, ModelMap model){
		FrontUtils.frontData(request, model);
		LemonUser user = (LemonUser) request.getSession().getAttribute("user") ;
		
		ImgMsg imgmsg = new ImgMsg() ;
		
		imgmsg.setStates(ImgStatusEnum.getImgStatusEnum(2)) ;//不查询已被删除的图片

		if(null!=user){
			page = imgHouseService.findByUser(page, user.getId(),imgmsg) ;
		}
		if(null!=page){
			List<ImgMsg> list = (List<ImgMsg>) page.getResult() ;
			List<Img> imglist = new ArrayList<Img>() ;
			for(ImgMsg img:list){
				imglist = imgService.getListBy(img.getId()) ;//根据父级id查找列表
				img.setImglist(imglist) ;
			}
			model.put("pager", page) ;
		}
		
		return "/WEB-INF/jsp/ucenter/imglist.jsp" ;
	}
	
	@RequestMapping(value="/ucenter/upload.jspx", method=RequestMethod.GET)
	public String viewUpload(HttpServletRequest request, HttpServletResponse response, ModelMap model){
		FrontUtils.frontData(request, model);

		return "/WEB-INF/jsp/ucenter/upload.jsp" ;
	}
	@RequestMapping(value="/ucenter/index.jspx", method={RequestMethod.GET, RequestMethod.POST})
	public String home(HttpServletRequest request, HttpServletResponse response, ModelMap model){
		FrontUtils.frontData(request, model);
		LemonUser user = (LemonUser) request.getSession().getAttribute("user") ;
		return "/WEB-INF/jsp/ucenter/index.jsp" ;
	}
}
