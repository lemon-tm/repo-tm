package com.lemon.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.lemon.service.impl.BaseServiceImpl;
import com.lemon.dao.VisitorRecordDao;
import com.lemon.entity.VisitorRecord;
import com.lemon.service.VisitorRecordService;

/*
 *  @author 
 */
@Service
public class VisitorRecordServiceImpl extends BaseServiceImpl<VisitorRecord,String> implements VisitorRecordService{

	@Resource
	private VisitorRecordDao visitorRecordDao;
	
	@Resource(name = "visitorRecordDaoImpl")
	public void setBaseDao(VisitorRecordDao visitorRecordDao) {
		super.setBaseDao(visitorRecordDao);
	}

}