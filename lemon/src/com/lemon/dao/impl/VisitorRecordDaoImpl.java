package com.lemon.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.lemon.dao.VisitorRecordDao;
import com.lemon.dao.impl.BaseDaoImpl;
import com.lemon.entity.VisitorRecord;

/*
 *  @author 
 */
@Repository
public class VisitorRecordDaoImpl extends BaseDaoImpl<VisitorRecord,String> implements VisitorRecordDao{
	@Override
	public List<Integer> getBy(VisitorRecord vr){
		String sql="select count(ip) from VisitorRecord where 1=1 ";
		if(null!=vr){
			String ip = vr.getIp() ;
			String requestUrl = vr.getRequestUrl() ;
			if(null!=ip && !"".equals(ip) && null!=requestUrl && !"".equals(requestUrl)){
				sql+=" and ip='"+ip+"' and requestUrl='"+requestUrl+"' and requestUrl not like '%lemon%' group by visitTime" ;
			}
		}else{
			return null;
		}
		Query q = getSession().createQuery(sql);
		
		return q.list();
	}
}