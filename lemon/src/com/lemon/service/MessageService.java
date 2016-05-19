package com.lemon.service;

import com.lemon.service.BaseService;
import com.lemon.util.Pager;
import com.lemon.entity.Message;

/*
 *  @author 
 */
public interface MessageService extends BaseService<Message,String>{

	Pager getMsgList(Pager page, Message msg);
	
}


