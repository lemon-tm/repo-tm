package com.lemon.admin.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.lemon.admin.dao.AdVisitorRecordDao;
import com.lemon.dao.impl.BaseDaoImpl;
import com.lemon.entity.LemonUser;
import com.lemon.entity.VisitorRecord;
import com.lemon.util.Pager;

/*
 *  @author 
 */
@Repository
public class AdVisitorRecordDaoImpl extends BaseDaoImpl<VisitorRecord,String> implements AdVisitorRecordDao{

	@Override
	public Pager getList(Pager pager) {
		Criteria criteria = getSession().createCriteria(VisitorRecord.class);
		criteria.addOrder(Order.desc("visitTime"));
		return findPager(pager, criteria);
	}

}