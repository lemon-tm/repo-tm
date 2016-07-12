package com.lemon.service;

import java.util.List;

import com.lemon.service.BaseService;
import com.lemon.entity.VisitorRecord;

/*
 *  @author 
 */
public interface VisitorRecordService extends BaseService<VisitorRecord,String>{

	List<Integer> getBy(VisitorRecord vr);

	
	
}


