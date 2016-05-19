package com.lemon.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.lemon.dao.MessageDao;
import com.lemon.dao.impl.BaseDaoImpl;
import com.lemon.entity.ImgHouse;
import com.lemon.entity.Message;
import com.lemon.util.Pager;

/*
 *  @author 
 */
@Repository
public class MessageDaoImpl extends BaseDaoImpl<Message,String> implements MessageDao{

	@Override
	public Pager getMsgList(Pager page, Message msg) {
		Criteria criteria = getSession().createCriteria(Message.class);
		
		if(null!=msg){
			if(!"".equals(msg.getUserId())){
				criteria.add(Restrictions.eq("userId",msg.getUserId()));
			}
		}
		criteria.addOrder(Order.desc("createTime"));
		return findPager(page, criteria);
	}

}