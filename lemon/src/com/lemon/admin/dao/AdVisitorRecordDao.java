package com.lemon.admin.dao;

import com.lemon.dao.BaseDao;
import com.lemon.entity.VisitorRecord;
import com.lemon.util.Pager;

/*
 *  @author 
 */
public interface AdVisitorRecordDao extends BaseDao<VisitorRecord, String>{

	Pager getList(Pager pager);

	Pager getRecordStatistics(Pager pager);

	Pager getRecordStatistics(Pager pager, VisitorRecord entity);
	
}