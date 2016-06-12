package com.lemon.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.lemon.dao.ImgMsgDao;
import com.lemon.dao.impl.BaseDaoImpl;
import com.lemon.entity.Img;
import com.lemon.entity.ImgMsg;

/*
 *  @author 
 */
@Repository
public class ImgMsgDaoImpl extends BaseDaoImpl<ImgMsg,String> implements ImgMsgDao{

	@Override
	public List<ImgMsg> getList() {
		String hql = "from ImgMsg v where 1=1 GROUP BY category" ;
		Query q  = getSession().createQuery(hql) ;
		return q.list();
	}

}