package com.lemon.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lemon.util.FrontUtils;

@Controller
public class FrameCor {
	@RequestMapping("main.do")
	public String toMain(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		FrontUtils.frontData(request, model);
		return "/WEB-INF/jsp/admin/frame/main.jsp";
	}
	@RequestMapping("top.do")
	public String toTop(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		FrontUtils.frontData(request, model);
		return "/WEB-INF/jsp/admin/frame/top.jsp";
	}
	
	//@RequiresPermissions("frame:af_main")
	@RequestMapping("/admin/left.do")
	public String toLeft(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		FrontUtils.frontData(request, model);
		return "/WEB-INF/jsp/admin/frame/left.jsp";
	}
	@RequestMapping("/admin/right.do")
	public String toRight(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		FrontUtils.frontData(request, model);
		return "/WEB-INF/jsp/admin/frame/right.jsp";
	}
}
