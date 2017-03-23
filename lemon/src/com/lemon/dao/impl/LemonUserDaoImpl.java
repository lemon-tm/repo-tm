package com.lemon.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.lemon.dao.LemonUserDao;
import com.lemon.entity.LemonUser;

@Repository
public class LemonUserDaoImpl extends BaseDaoImpl<LemonUser,String> implements LemonUserDao  {
	
	
	
	public LemonUser findLemonUser(LemonUser user) {
		String hql = "from LemonUser bean ";
		if(user!=null){
			hql+=" where bean.username=? and bean.password=?";
		}
		Query query = getSession().createQuery(hql);
		if(user!=null){
			query.setParameter(0, user.getUsername()) ;
			query.setParameter(1, user.getPassword()) ;
		}
		// 做一些容错处理，因为毕竟没有在数据库中限定path是唯一的。
		query.setMaxResults(1);
		return (LemonUser) query.uniqueResult();
	}

	@Override
	public LemonUser getUser(LemonUser user) {
		String hql = "from LemonUser bean ";
		if(user!=null){
			hql+=" where bean.username=? ";
		}
		Query query = getSession().createQuery(hql);
		if(user!=null){
			query.setParameter(0, user.getUsername()) ;
		}
		// 做一些容错处理，因为毕竟没有在数据库中限定path是唯一的。
		query.setMaxResults(1);
		return (LemonUser) query.uniqueResult();
	}

	@Override
	public LemonUser findByUsername(String username) {
		String hql = "from LemonUser where username=:username " ;
		Query q = getSession().createQuery(hql) ;
		q.setParameter("username", username) ;
		
		return (LemonUser) q.list().get(0) ;
	}
	
}
