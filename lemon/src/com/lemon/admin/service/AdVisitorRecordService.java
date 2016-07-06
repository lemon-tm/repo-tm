package com.lemon.admin.service;

import com.lemon.entity.VisitorRecord;
import com.lemon.service.BaseService;
import com.lemon.util.Pager;

/*
 *  @author 
 */
public interface AdVisitorRecordService extends BaseService<VisitorRecord,String>{

	Pager getList(Pager pager);

	Pager getRecordStatistics(Pager pager);

	Pager getList(Pager pager, VisitorRecord entity);
	
}


