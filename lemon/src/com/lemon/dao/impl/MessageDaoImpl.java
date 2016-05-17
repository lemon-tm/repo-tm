package com.lemon.dao.impl;

import org.springframework.stereotype.Repository;

import com.lemon.dao.MessageDao;
import com.lemon.dao.impl.BaseDaoImpl;
import com.lemon.entity.Message;

/*
 *  @author 
 */
@Repository
public class MessageDaoImpl extends BaseDaoImpl<Message,String> implements MessageDao{

}