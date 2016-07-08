package com.lemon.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.lemon.service.impl.BaseServiceImpl;
import com.lemon.dao.ForbiddenIpDao;
import com.lemon.entity.ForbiddenIp;
import com.lemon.service.ForbiddenIpService;

/*
 *  @author 
 */
@Service
public class ForbiddenIpServiceImpl extends BaseServiceImpl<ForbiddenIp,String> implements ForbiddenIpService{

	@Resource
	private ForbiddenIpDao forbiddenIpDao;
	
	@Resource(name = "forbiddenIpDaoImpl")
	public void setBaseDao(ForbiddenIpDao forbiddenIpDao) {
		super.setBaseDao(forbiddenIpDao);
	}

}