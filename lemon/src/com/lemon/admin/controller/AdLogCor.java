package com.lemon.admin.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lemon.admin.service.AdVisitorRecordService;
import com.lemon.entity.LemonUser;
import com.lemon.util.FrontUtils;
import com.lemon.util.Pager;

@Controller
public class AdLogCor {

	@Resource
	private AdVisitorRecordService adVisitorRecordService ;
	/**
	 * hhc add 2016-06-23 16：18
	 * 后台管理，访客记录
	 * 
	 */
	@RequestMapping(value="/ucenter/visit_record_list.do", method={RequestMethod.GET, RequestMethod.POST})
	public String getlogList(Pager pager, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		FrontUtils.frontData(request, model);
		LemonUser user = (LemonUser) request.getSession().getAttribute("user") ;
		pager.setPageSize(100) ;
		pager = adVisitorRecordService.getList(pager) ;
		model.put("user", user) ;
		model.put("pager", pager) ;
		return "/WEB-INF/jsp/admin/visit_record_list.jsp" ;
	}
}
