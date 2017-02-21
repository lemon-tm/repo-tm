package com.lemon.dao.impl;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;


import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.CriteriaImpl;
import org.hibernate.internal.CriteriaImpl.OrderEntry;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.util.Assert;

import com.lemon.dao.BaseDao;
import com.lemon.entity.BaseEntity;
import com.lemon.util.Finder;
import com.lemon.util.Pager;
import com.lemon.util.ReflectionUtil;


/**
 * Dao实现类 - 基类
 */

public class BaseDaoImpl<T, PK extends Serializable> implements BaseDao<T, PK> {

	private static final String ORDER_LIST_PROPERTY_NAME = "orderList";// "排序"属性名称
	private static final String CREATE_DATE_PROPERTY_NAME = "createDate";// "创建日期"属性名称
	
	private Class<T> entityClass;
	protected SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
        Class c = getClass();
        Type type = c.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
            this.entityClass = (Class<T>) parameterizedType[0];
        }
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public T get(PK id) {
		Assert.notNull(id, "id is required");
		return (T) getSession().get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public T load(PK id) {
		Assert.notNull(id, "id is required");
		return (T) getSession().load(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> getAllList() {
		ClassMetadata classMetadata = sessionFactory.getClassMetadata(entityClass);
		String hql;
		if (ArrayUtils.contains(classMetadata.getPropertyNames(), ORDER_LIST_PROPERTY_NAME)) {
			hql = "from " + entityClass.getName() + " as entity order by entity." + ORDER_LIST_PROPERTY_NAME + " desc";
		} else {
			hql = "from " + entityClass.getName();
		}
		Query q = getSession().createQuery(hql) ;
		q.setCacheable(true) ;
		return q.list();
	}
	
	public Long getTotalCount() {
		String hql = "select count(*) from " + entityClass.getName();
		return (Long) getSession().createQuery(hql).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public PK save(T entity) {
		Assert.notNull(entity, "entity is required");
		if (entity instanceof BaseEntity) {
			try {
				Method method = entity.getClass().getMethod(BaseEntity.ON_SAVE_METHOD_NAME);
				method.invoke(entity);
				PK a =(PK) getSession().save(entity);
//				getSession().flush();
				return a ; 
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return (PK) getSession().save(entity);
		}
	}

	public void update(T entity) {
		Assert.notNull(entity, "entity is required");
		if (entity instanceof BaseEntity) {
			try {
				Method method = entity.getClass().getMethod(BaseEntity.ON_UPDATE_METHOD_NAME);
				method.invoke(entity);
				getSession().update(entity);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			getSession().update(entity);
		}
	}
	
	public void saveOrupdate(T entity) {
		Assert.notNull(entity, "entity is required");
		if (entity instanceof BaseEntity) {
			try {
				Method method = entity.getClass().getMethod(BaseEntity.ON_SAVEORUPDATE_METHOD_NAME);
				method.invoke(entity);
				getSession().saveOrUpdate(entity) ;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			getSession().saveOrUpdate(entity) ;
		}
		
	}

	public void delete(T entity) {
		Assert.notNull(entity, "entity is required");
		getSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public void delete(PK id) {
		Assert.notNull(id, "id is required");
		T entity = (T) getSession().load(entityClass, id);
		getSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public void delete(PK[] ids) {
		Assert.notEmpty(ids, "ids must not be empty");
		for (PK id : ids) {
			T entity = (T) getSession().load(entityClass, id);
			getSession().delete(entity);
		}
	}

	public void flush() {
		getSession().flush();
	}

	public void evict(Object object) {
		Assert.notNull(object, "object is required");
		getSession().evict(object);
	}

	public void clear() {
		getSession().clear();
	}
	
	public Pager findPager(Pager pager) {
		Criteria criteria = getSession().createCriteria(entityClass);
		return findPager(pager, criteria);
	}
	
	public Pager findPager(Pager pager, Criterion... criterions) {
		Criteria criteria = getSession().createCriteria(entityClass);
		for (Criterion criterion : criterions) {
			criteria.add(criterion);
		}
		return findPager(pager, criteria);
	}
	
	public Pager findPager(Pager pager, Order... orders) {
		Criteria criteria = getSession().createCriteria(entityClass);
		for (Order order : orders) {
			criteria.addOrder(order);
		}
		return findPager(pager, criteria);
	}
	
	public Pager findPager(Pager pager, Criteria criteria) {
		Assert.notNull(pager, "pager is required");
		Assert.notNull(criteria, "criteria is required");
		
		Integer pageNumber = pager.getPageNumber();
		Integer pageSize = pager.getPageSize();
		String searchBy = pager.getSearchBy();
		String keyword = pager.getKeyword();
		String orderBy = pager.getOrderBy();
		Pager.Order order = pager.getOrder();
		
		if (StringUtils.isNotEmpty(searchBy) && StringUtils.isNotEmpty(keyword)) {
			if (searchBy.contains(".")) {
				String alias = StringUtils.substringBefore(searchBy, ".");
				criteria.createAlias(alias, alias);
			}
			criteria.add(Restrictions.like(searchBy, "%" + keyword + "%"));
		}
		
		pager.setTotalCount(criteriaResultTotalCount(criteria));
		
		if (StringUtils.isNotEmpty(orderBy) && order != null) {
			if (order == Pager.Order.asc) {
				criteria.addOrder(Order.asc(orderBy));
			} else {
				criteria.addOrder(Order.desc(orderBy));
			}
		}
		
		ClassMetadata classMetadata = sessionFactory.getClassMetadata(entityClass);
		if (!StringUtils.equals(orderBy, ORDER_LIST_PROPERTY_NAME) && ArrayUtils.contains(classMetadata.getPropertyNames(), ORDER_LIST_PROPERTY_NAME)) {
			criteria.addOrder(Order.asc(ORDER_LIST_PROPERTY_NAME));
			criteria.addOrder(Order.desc(CREATE_DATE_PROPERTY_NAME));
			if (StringUtils.isEmpty(orderBy) || order == null) {
				pager.setOrderBy(ORDER_LIST_PROPERTY_NAME);
				pager.setOrder(Pager.Order.asc);
			}
		} else if (!StringUtils.equals(orderBy, CREATE_DATE_PROPERTY_NAME) && ArrayUtils.contains(classMetadata.getPropertyNames(), CREATE_DATE_PROPERTY_NAME)) {
			criteria.addOrder(Order.desc(CREATE_DATE_PROPERTY_NAME));
			if (StringUtils.isEmpty(orderBy) || order == null) {
				pager.setOrderBy(CREATE_DATE_PROPERTY_NAME);
				pager.setOrder(Pager.Order.desc);
			}
		}
		
		criteria.setFirstResult((pageNumber - 1) * pageSize);
		criteria.setMaxResults(pageSize);
		
		pager.setResult(criteria.list());
		return pager;
	}
	
	
	
	// 获取Criteria查询数量
	@SuppressWarnings("unchecked")
	private int criteriaResultTotalCount(Criteria criteria) {
		Assert.notNull(criteria, "criteria is required");
		
		int criteriaResultTotalCount = 0;
		try {
			CriteriaImpl criteriaImpl = (CriteriaImpl) criteria;
			
			Projection projection = criteriaImpl.getProjection();
			ResultTransformer resultTransformer = criteriaImpl.getResultTransformer();
			List<OrderEntry> orderEntries = (List) ReflectionUtil.getFieldValue(criteriaImpl, "orderEntries");
			ReflectionUtil.setFieldValue(criteriaImpl, "orderEntries", new ArrayList());
			
			Integer totalCount = ((Long) criteriaImpl.setProjection(Projections.rowCount()).uniqueResult()).intValue();
			if (totalCount != null) {
				criteriaResultTotalCount = totalCount;
			}
			
			criteriaImpl.setProjection(projection);
			if (projection == null) {
				criteriaImpl.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
			}
			if (resultTransformer != null) {
				criteriaImpl.setResultTransformer(resultTransformer);
			}
			ReflectionUtil.setFieldValue(criteriaImpl, "orderEntries", orderEntries);
		} catch (Exception e) {
			
		}
		return criteriaResultTotalCount;
	}
	
	
	
	/**
	 * 通过Finder获得列表数据
	 * 
	 * @param finder
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected List find(Finder finder) {
		Query query = finder.createQuery(getSession());
		List list = query.list();
		return list;
	}
	protected void appendOrder(Finder f, int orderBy) {
		switch (orderBy) {
		case 1:
			// ID升序
			f.append(" order by bean.id asc");
			break;
		case 2:
			// 发布时间降序
			f.append(" order by bean.sortDate desc");
			break;
		case 3:
			// 发布时间升序
			f.append(" order by bean.sortDate asc");
			break;
		case 4:
			// 固顶级别降序、发布时间降序
			f.append(" order by bean.topLevel desc, bean.sortDate desc");
			break;
		case 5:
			// 固顶级别降序、发布时间升序
			f.append(" order by bean.topLevel desc, bean.sortDate asc");
			break;
		case 6:
			// 日访问降序
			f.append(" order by bean.contentCount.viewsDay desc, bean.id desc");
			break;
		case 7:
			// 周访问降序
			f.append(" order by bean.contentCount.viewsWeek desc");
			f.append(", bean.id desc");
			break;
		case 8:
			// 月访问降序
			f.append(" order by bean.contentCount.viewsMonth desc");
			f.append(", bean.id desc");
			break;
		case 9:
			// 总访问降序
			f.append(" order by bean.contentCount.views desc");
			f.append(", bean.id desc");
			break;
		case 10:
			// 日评论降序
			f.append(" order by bean.commentsDay desc, bean.id desc");
			break;
		case 11:
			// 周评论降序
			f.append(" order by bean.contentCount.commentsWeek desc");
			f.append(", bean.id desc");
			break;
		case 12:
			// 月评论降序
			f.append(" order by bean.contentCount.commentsMonth desc");
			f.append(", bean.id desc");
			break;
		case 13:
			// 总评论降序
			f.append(" order by bean.contentCount.comments desc");
			f.append(", bean.id desc");
			break;
		case 14:
			// 日下载降序
			f.append(" order by bean.downloadsDay desc, bean.id desc");
			break;
		case 15:
			// 周下载降序
			f.append(" order by bean.contentCount.downloadsWeek desc");
			f.append(", bean.id desc");
			break;
		case 16:
			// 月下载降序
			f.append(" order by bean.contentCount.downloadsMonth desc");
			f.append(", bean.id desc");
			break;
		case 17:
			// 总下载降序
			f.append(" order by bean.contentCount.downloads desc");
			f.append(", bean.id desc");
			break;
		case 18:
			// 日顶降序
			f.append(" order by bean.upsDay desc, bean.id desc");
			break;
		case 19:
			// 周顶降序
			f.append(" order by bean.contentCount.upsWeek desc");
			f.append(", bean.id desc");
			break;
		case 20:
			// 月顶降序
			f.append(" order by bean.contentCount.upsMonth desc");
			f.append(", bean.id desc");
			break;
		case 21:
			// 总顶降序
			f.append(" order by bean.contentCount.ups desc, bean.id desc");
			break;
		default:
			// 默认： ID降序
			f.append(" order by bean.id desc");
		}
	}

	

	
	/*********************SQL 分页查询 start **************************/
	public Pager findPager(Pager pager, String sql) {
		Assert.notNull(pager, "pager is required");
		Assert.notNull(sql, "sql is required");
		
		pager.setTotalCount(criteriaResultTotalCount(sql));
		Query query = getSession().createSQLQuery(sql)
//				.addScalar("companyStatus", StandardBasicTypes.)
				.setResultTransformer(Transformers.aliasToBean(entityClass));
		query.setFirstResult((pager.getPageNumber()-1)*pager.getPageSize());
		query.setMaxResults(pager.getPageSize());
		pager.setResult(query.list());
		return pager;
	}
	
	private int criteriaResultTotalCount(String sql) {
		Assert.notNull(sql, "sql is required");
		
		int criteriaResultTotalCount = 0;
		Query query = getSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(entityClass));
		List list = query.list();
		if(list!=null){
			criteriaResultTotalCount = list.size();
		}
		return criteriaResultTotalCount;
	}
	/*********************SQL 分页查询 end **************************/

	
}