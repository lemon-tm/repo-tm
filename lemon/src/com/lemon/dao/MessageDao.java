package com.lemon.dao;

import com.lemon.dao.BaseDao;
import com.lemon.entity.Message;
import com.lemon.util.Pager;

/*
 *  @author 
 */
public interface MessageDao extends BaseDao<Message, String>{

	Pager getMsgList(Pager page, Message msg);
	
}