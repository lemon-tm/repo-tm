package com.lemon.service;

import java.util.List;

import com.lemon.service.BaseService;
import com.lemon.util.Pager;
import com.lemon.entity.Img;
import com.lemon.entity.ImgMsg;

/*
 *  @author 
 */
public interface ImgMsgService extends BaseService<ImgMsg,String>{
	/**
	 * hhc add 2016-06-12
	 * 根据分类查找一张图，用于首页
	 * select * from img_msg GROUP BY category order by create_time desc
	 * */
	List<ImgMsg> getList();

	Pager findByUser(Pager page, String id, ImgMsg imgmsg);
	
}


