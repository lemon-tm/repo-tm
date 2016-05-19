package com.lemon.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.lemon.service.impl.BaseServiceImpl;
import com.lemon.dao.MessageDao;
import com.lemon.entity.Message;
import com.lemon.service.MessageService;
import com.lemon.util.Pager;

/*
 *  @author 
 */
@Service
public class MessageServiceImpl extends BaseServiceImpl<Message,String> implements MessageService{

	@Resource
	private MessageDao messageDao;
	
	@Resource(name = "messageDaoImpl")
	public void setBaseDao(MessageDao messageDao) {
		super.setBaseDao(messageDao);
	}

	@Override
	public Pager getMsgList(Pager page, Message msg) {
		return messageDao.getMsgList(page, msg);
	}

}