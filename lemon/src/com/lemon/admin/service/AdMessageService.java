package com.lemon.admin.service;

import com.lemon.entity.Message;
import com.lemon.service.BaseService;
import com.lemon.util.Pager;


/*
 *  @author 
 */
public interface AdMessageService extends BaseService<Message,String>{

	Pager getList(Pager pager);
	
}


