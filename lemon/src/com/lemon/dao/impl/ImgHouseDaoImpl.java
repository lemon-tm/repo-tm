package com.lemon.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.lemon.constant.font.enums.ImgStatusEnum;
import com.lemon.constant.font.enums.VerifyEnum;
import com.lemon.dao.ImgHouseDao;
import com.lemon.entity.ImgHouse;
import com.lemon.entity.ImgMsg;
import com.lemon.util.Pager;

/*
 *  @author 
 */
@Repository
public class ImgHouseDaoImpl extends BaseDaoImpl<ImgHouse,String> implements ImgHouseDao{

	public Pager findByUser(Pager page, String userId, ImgMsg img) {
		
		Criteria criteria =getSession().createCriteria(ImgMsg.class);
		if(null!=userId && !"".equals(userId)){
			criteria.add(Restrictions.eq("userId",userId));
		}
		if(null!=img){
			if(!"".equals(img.getStates())){
				criteria.add(Restrictions.ne("states", img.getStates())) ;
			}
		}
		criteria.addOrder(Order.desc("createTime"));
		return findPager(page, criteria);
	}

	public Pager getList(Pager pager) {

		Criteria criteria = getSession().createCriteria(ImgHouse.class);
		
		criteria.add(Restrictions.eq("isverify",VerifyEnum.getVerifyEnum(1)));
		criteria.add(Restrictions.ne("status",ImgStatusEnum.getImgStatusEnum(2)));
		criteria.addOrder(Order.desc("createTime"));
		
		return findPager(pager, criteria);
	}

	@Override
	public Pager getList(Pager pager, String keywords) {
		Criteria criteria = getSession().createCriteria(ImgHouse.class);
		
		criteria.add(Restrictions.eq("isverify",VerifyEnum.getVerifyEnum(1)));
		criteria.add(Restrictions.ne("status",ImgStatusEnum.getImgStatusEnum(2)));
		if(null!=keywords && !"".equals(keywords)){
			criteria.add(Restrictions.or(Restrictions.like("name", "%"+keywords+"%"), Restrictions.like("describe", "%"+keywords+"%")));
		}
		
		criteria.addOrder(Order.desc("createTime"));
		
		return findPager(pager, criteria);
	}

}