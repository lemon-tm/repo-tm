package com.lemon.service;

import com.lemon.entity.ImgHouse;
import com.lemon.entity.ImgMsg;
import com.lemon.util.Pager;

/*
 *  @author 
 */
public interface ImgHouseService extends BaseService<ImgHouse,String>{

	Pager findByUser(Pager page, String id, ImgMsg img);

	Pager getList(Pager pager);

	Pager getList(Pager pager, String keywords);



	
}


