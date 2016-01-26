package com.lemon.service;

import com.lemon.service.BaseService;
import com.lemon.util.Pager;
import com.lemon.entity.ImgHouse;

/*
 *  @author 
 */
public interface ImgHouseService extends BaseService<ImgHouse,String>{

	Pager findByUser(Pager page, String id);

	Pager getList(Pager pager);



	
}


