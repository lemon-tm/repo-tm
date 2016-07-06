package com.lemon.admin.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.lemon.admin.dao.AdVisitorRecordDao;
import com.lemon.constant.font.enums.ImgStatusEnum;
import com.lemon.constant.font.enums.VerifyEnum;
import com.lemon.dao.impl.BaseDaoImpl;
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

	private int getTotalCountBy(String sql) {
		int totalCount = 0;
		Query q = getSession().createQuery(sql) ;
		List list = q.list();
		if(list!=null){
			totalCount = list.size();
		}
		return totalCount;
	}
	@Override
	public Pager getRecordStatistics(Pager pager) {
		String sql ="select ip,count(ip) as counts from VisitorRecord GROUP BY ip order by counts desc" ;
		
		Query q = getSession().createQuery(sql) ;
		q.setFirstResult((pager.getPageNumber()-1)*pager.getPageSize()) ;
		q.setMaxResults(pager.getPageSize()) ;
		pager = findPager(pager) ;
		pager.setResult(q.list()) ;
		pager.setTotalCount(getTotalCountBy(sql));
		return pager;
	}

	@Override
	public Pager getRecordStatistics(Pager pager, VisitorRecord entity) {
		Criteria criteria = getSession().createCriteria(VisitorRecord.class);
		
		if(null!=entity && null!=entity.getIp() && entity.getIp().length()>0){
			criteria.add(Restrictions.eq("ip",entity.getIp()));
		}
		criteria.addOrder(Order.desc("visitTime"));
		return findPager(pager, criteria);
	}

}