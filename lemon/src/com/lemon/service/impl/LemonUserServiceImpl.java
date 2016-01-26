package com.lemon.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lemon.dao.LemonUserDao;
import com.lemon.entity.LemonUser;
import com.lemon.service.LemonUserService;

@Service
public class LemonUserServiceImpl extends BaseServiceImpl<LemonUser,String> implements LemonUserService {

	@Resource
	private LemonUserDao lemonUserDao ;
	
	@Resource(name = "lemonUserDaoImpl")
	public void setBaseDao(LemonUserDao lemonUserDao) {
		super.setBaseDao(lemonUserDao);
	}
	public LemonUser findLemonUser(LemonUser user) {
		return lemonUserDao.findLemonUser(user) ;
	}


}
