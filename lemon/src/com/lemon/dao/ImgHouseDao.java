package com.lemon.dao;

import com.lemon.dao.BaseDao;
import com.lemon.entity.ImgHouse;
import com.lemon.util.Pager;

/*
 *  @author 
 */
public interface ImgHouseDao extends BaseDao<ImgHouse, String>{

	Pager findByUser(Pager page, String userId, ImgHouse img);

	Pager getList(Pager pager);
	
}