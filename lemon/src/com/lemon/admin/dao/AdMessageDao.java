package com.lemon.admin.dao;

import com.lemon.dao.BaseDao;
import com.lemon.entity.Message;
import com.lemon.util.Pager;


/*
 *  @author 
 */
public interface AdMessageDao extends BaseDao<Message, String>{

	Pager getList(Pager pager);
	
}