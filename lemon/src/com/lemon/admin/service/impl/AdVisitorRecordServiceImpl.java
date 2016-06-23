package com.lemon.admin.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lemon.admin.dao.AdVisitorRecordDao;
import com.lemon.admin.service.AdVisitorRecordService;
import com.lemon.entity.VisitorRecord;
import com.lemon.service.impl.BaseServiceImpl;
import com.lemon.util.Pager;

/*
 *  @author 
 */
@Service
public class AdVisitorRecordServiceImpl extends BaseServiceImpl<VisitorRecord,String> implements AdVisitorRecordService{

	@Resource
	private AdVisitorRecordDao adVisitorRecordDao;
	
	@Resource(name = "adVisitorRecordDaoImpl")
	public void setBaseDao(AdVisitorRecordDao adVisitorRecordDao) {
		super.setBaseDao(adVisitorRecordDao);
	}

	@Override
	public Pager getList(Pager pager) {
		return adVisitorRecordDao.getList(pager);
	}

}