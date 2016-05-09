package com.lemon.admin.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.lemon.admin.dao.AdLemonUserDao;
import com.lemon.dao.impl.BaseDaoImpl;
import com.lemon.entity.ImgHouse;
import com.lemon.entity.LemonUser;
import com.lemon.util.Pager;

/*
 *  @author 
 */
@Repository
public class AdLemonUserDaoImpl extends BaseDaoImpl<LemonUser,String> implements AdLemonUserDao{

	@Override
	public Pager getList(Pager pager) {
		Criteria criteria = getSession().createCriteria(LemonUser.class);
		criteria.addOrder(Order.desc("registTime"));
		return findPager(pager, criteria);
	}
}