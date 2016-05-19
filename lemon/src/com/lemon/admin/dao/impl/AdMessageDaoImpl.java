package com.lemon.admin.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.lemon.admin.dao.AdMessageDao;
import com.lemon.dao.impl.BaseDaoImpl;
import com.lemon.entity.Message;
import com.lemon.util.Pager;

/*
 *  @author 
 */
@Repository
public class AdMessageDaoImpl extends BaseDaoImpl<Message,String> implements AdMessageDao{

	@Override
	public Pager getList(Pager pager) {
		Criteria criteria = getSession().createCriteria(Message.class);
		criteria.addOrder(Order.asc("states"));
		criteria.addOrder(Order.asc("createTime"));
		return findPager(pager, criteria);
	}

}