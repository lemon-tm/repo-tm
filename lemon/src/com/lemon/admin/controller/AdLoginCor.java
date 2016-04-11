package com.lemon.admin.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lemon.admin.service.AdImgService;
import com.lemon.entity.ImgHouse;
import com.lemon.entity.LemonUser;
import com.lemon.util.FrontUtils;
import com.lemon.util.Pager;
import com.lemon.util.ResponseUtils;

@Controller
public class AdLoginCor {
	@Resource
	private AdImgService adImgService ;
	
	
	
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
		ImgHouse img = new ImgHouse() ;

		pager = adImgService.getList(pager, user, img) ;
		
		model.put("user", user) ;
		model.put("pager", pager) ;
		return "/WEB-INF/jsp/admin/imglist.jsp" ;
	}

	/**
	 * hhc add 2016-04-11 16:35
	 * 审核图片
	 * */
	@RequestMapping(value="/ucenter/isverify.do", method = RequestMethod.POST)
	public void isverify(String imgId, Integer verify, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws ServletException, IOException{
		FrontUtils.frontData(request, model);
		LemonUser user = (LemonUser) request.getSession().getAttribute("user") ;

		ImgHouse img = adImgService.get(imgId) ;
		if(null!=img){
			img.setIsverify(verify) ;
		}
		adImgService.saveOrUpdate(img) ;
		JSONObject json = new JSONObject();
		json.put("verify", img.getIsverify());
		ResponseUtils.renderJson(response, json.toString());
	}
}
