package com.lemon.admin.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.lemon.admin.dao.AdImgDao;
import com.lemon.dao.impl.BaseDaoImpl;
import com.lemon.entity.Img;
import com.lemon.entity.ImgHouse;
import com.lemon.entity.LemonUser;
import com.lemon.util.Pager;

/*
 *  @author 
 */
@Repository
public class AdImgDaoImpl extends BaseDaoImpl<Img,String> implements AdImgDao{

	@Override
	public Pager getList(Pager pager, LemonUser user, ImgHouse img) {
		Criteria criteria = getSession().createCriteria(ImgHouse.class);
		if(null!=img && null!=img.getIsverify()){
			criteria.add(Restrictions.eq("isverify",1));
			
		}
		criteria.addOrder(Order.desc("createTime"));
		return findPager(pager, criteria);
	}

	@Override
	public List<Img> getListBy(Img img) {
		
		String hql = "from Img v where 1=1 " ;
		if(null!=img && img.getRelationId().length()>0){
			hql+=" and v.relationId=:relationId" ;
		}
		Query q  = getSession().createQuery(hql) ;
		if(null!=img && img.getRelationId().length()>0){
			q.setParameter("relationId",  img.getRelationId()) ;
		}
		return q.list();
		
	}
	
}