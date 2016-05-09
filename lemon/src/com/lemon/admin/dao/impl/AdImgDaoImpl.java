package com.lemon.admin.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.lemon.admin.dao.AdImgDao;
import com.lemon.dao.impl.BaseDaoImpl;
import com.lemon.entity.ImgHouse;
import com.lemon.entity.LemonUser;
import com.lemon.util.Pager;

/*
 *  @author 
 */
@Repository
public class AdImgDaoImpl extends BaseDaoImpl<ImgHouse,String> implements AdImgDao{

	@Override
	public Pager getList(Pager pager, LemonUser user, ImgHouse img) {
		Criteria criteria = getSession().createCriteria(ImgHouse.class);
		if(null!=img && null!=img.getIsverify()){
			criteria.add(Restrictions.eq("isverify",1));
			
		}
		criteria.addOrder(Order.desc("createTime"));
		return findPager(pager, criteria);
	}
	
}