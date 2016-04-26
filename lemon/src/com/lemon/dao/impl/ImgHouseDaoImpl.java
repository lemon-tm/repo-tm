package com.lemon.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.lemon.admin.dao.impl.BaseDaoImpl;
import com.lemon.constant.font.enums.VerifyEnum;
import com.lemon.dao.ImgHouseDao;
import com.lemon.entity.ImgHouse;
import com.lemon.util.Pager;

/*
 *  @author 
 */
@Repository
public class ImgHouseDaoImpl extends BaseDaoImpl<ImgHouse,String> implements ImgHouseDao{

	public Pager findByUser(Pager page, String userId) {
		Criteria criteria = getSession().createCriteria(ImgHouse.class);
		if(null!=userId && !"".equals(userId)){
			criteria.add(Restrictions.eq("userId",userId));
		}
		criteria.addOrder(Order.desc("createTime"));
		return findPager(page, criteria);
	}

	public Pager getList(Pager pager) {

		Criteria criteria = getSession().createCriteria(ImgHouse.class);
		
		criteria.add(Restrictions.eq("isverify",VerifyEnum.getVerifyEnum(1)));
		
		criteria.addOrder(Order.desc("createTime"));
		
		return findPager(pager, criteria);
	}

	

}