package com.lemon.dao;

import com.lemon.entity.ImgHouse;
import com.lemon.entity.ImgMsg;
import com.lemon.util.Pager;

/*
 *  @author 
 */
public interface ImgHouseDao extends BaseDao<ImgHouse, String>{

	Pager findByUser(Pager page, String userId, ImgMsg img);

	Pager getList(Pager pager);

	Pager getList(Pager pager, String keywords);
	
}