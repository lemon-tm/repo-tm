package com.lemon.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.lemon.dao.ImgMsgDao;
import com.lemon.entity.ImgMsg;
import com.lemon.util.Pager;

/*
 *  @author 
 */
@Repository
public class ImgMsgDaoImpl extends BaseDaoImpl<ImgMsg,String> implements ImgMsgDao{

	@Override
	public List<ImgMsg> getList() {
		//String hql = "select * from (select * from img_msg where 1=1 order by create_time desc) v GROUP BY v.category" ;
		String sql = "select * from (select * from img_msg where 1=1 and states!=2 and id in(" +
				"select DISTINCT(relation_id) from img where isverify='1' " +
				") order by create_time desc) v GROUP BY v.category  " ;
		Query q = getSession().createSQLQuery(sql).addEntity(ImgMsg.class) ;
		return q.list();
	}

	@Override
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

}