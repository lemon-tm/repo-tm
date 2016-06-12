package com.lemon.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.lemon.constant.font.enums.ImgStatusEnum;
import com.lemon.constant.font.enums.VerifyEnum;
import com.lemon.dao.ImgDao;
import com.lemon.entity.Img;
import com.lemon.entity.ImgHouse;
import com.lemon.entity.ImgMsg;
import com.lemon.util.Pager;

/*
 *  @author 
 */
@Repository
public class ImgDaoImpl extends BaseDaoImpl<Img,String> implements ImgDao{

	@Override
	public List<Img> getListBy(String relationId) {
		String hql = "from Img v where 1=1 " ;
		if(StringUtils.isNotEmpty(relationId)){
			hql+=" and v.relationId=:relationId" ;
		}
		Query q  = getSession().createQuery(hql) ;
		q.setParameter("relationId",  relationId) ;
		return q.list();
	}

	@Override
	public Pager getList(Pager pager, String keywords, String category) {
		String sql ="from Img v where v.isverify=:isverify and v.relationId in(" +
				"select id from ImgMsg m where m.states!=:states " ;
		if(null!=keywords && keywords.length()>0){
			sql+=" and m.name like'%"+keywords+"%' " ;
		}
		if(null!=category && category.length()>0){
			sql+=" and m.category='"+category+"' " ;
		}
		sql+=")" ;
		Query q = getSession().createQuery(sql) ;
		q.setParameter("isverify", VerifyEnum.getVerifyEnum(1)) ;
		q.setParameter("states", ImgStatusEnum.getImgStatusEnum(2)) ;
		q.setFirstResult((pager.getPageNumber()-1)*pager.getPageSize()) ;
		q.setMaxResults(pager.getPageSize()) ;
		pager = findPager(pager) ;
		pager.setResult(q.list()) ;
		return pager;
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
		q.setMaxResults(1) ;
		return q.list();
		
	}

}