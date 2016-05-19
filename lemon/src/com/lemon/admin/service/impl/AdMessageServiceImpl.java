package com.lemon.admin.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.lemon.admin.dao.AdMessageDao;
import com.lemon.admin.service.AdMessageService;
import com.lemon.entity.Message;
import com.lemon.service.impl.BaseServiceImpl;
import com.lemon.util.Pager;

/*
 *  @author 
 */
@Service
public class AdMessageServiceImpl extends BaseServiceImpl<Message,String> implements AdMessageService{

	@Resource
	private AdMessageDao adMessageDao;
	
	@Resource(name = "adMessageDaoImpl")
	public void setBaseDao(AdMessageDao adMessageDao) {
		super.setBaseDao(adMessageDao);
	}

	@Override
	public Pager getList(Pager pager) {
		return adMessageDao.getList(pager);
	}

}