package com.lemon.admin.dao;

import com.lemon.dao.BaseDao;
import com.lemon.entity.ImgHouse;
import com.lemon.entity.LemonUser;
import com.lemon.util.Pager;

/*
 *  @author 
 */
public interface AdImgDao extends BaseDao<ImgHouse, String>{

	Pager getList(Pager pager, LemonUser user, ImgHouse img);
	
}