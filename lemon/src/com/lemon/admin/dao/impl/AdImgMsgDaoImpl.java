package com.lemon.admin.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.lemon.admin.dao.AdImgMsgDao;
import com.lemon.dao.impl.BaseDaoImpl;
import com.lemon.entity.Img;
import com.lemon.entity.ImgHouse;
import com.lemon.entity.ImgMsg;
import com.lemon.entity.LemonUser;
import com.lemon.util.Pager;

/*
 *  @author 
 */
@Repository
public class AdImgMsgDaoImpl extends BaseDaoImpl<ImgMsg,String> implements AdImgMsgDao{

	@Override
	public Pager getList(Pager pager, LemonUser user, Img img) {
		
		Criteria criteria = getSession().createCriteria(ImgMsg.class);
		
		criteria.addOrder(Order.desc("createTime"));
		return findPager(pager, criteria);
		
	}

}