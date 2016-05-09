package com.lemon.admin.dao;

import com.lemon.dao.BaseDao;
import com.lemon.entity.LemonUser;
import com.lemon.util.Pager;

/*
 *  @author 
 */
public interface AdLemonUserDao extends BaseDao<LemonUser, String>{

	Pager getList(Pager pager);
	
}