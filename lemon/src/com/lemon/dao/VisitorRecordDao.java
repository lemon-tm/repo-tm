package com.lemon.dao;

import java.util.List;

import com.lemon.dao.BaseDao;
import com.lemon.entity.VisitorRecord;

/*
 *  @author 
 */
public interface VisitorRecordDao extends BaseDao<VisitorRecord, String>{

	List<Integer> getBy(VisitorRecord vr);
	
}