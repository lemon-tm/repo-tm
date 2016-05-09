package com.lemon.admin.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lemon.admin.dao.AdLemonUserDao;
import com.lemon.admin.service.AdLemonUserService;
import com.lemon.entity.LemonUser;
import com.lemon.service.impl.BaseServiceImpl;
import com.lemon.util.Pager;

/*
 *  @author 
 */
@Service
public class AdLemonUserServiceImpl extends BaseServiceImpl<LemonUser,String> implements AdLemonUserService{

	@Resource
	private AdLemonUserDao adLemonUserDao;
	
	@Resource(name = "adLemonUserDaoImpl")
	public void setBaseDao(AdLemonUserDao adLemonUserDao) {
		super.setBaseDao((com.lemon.dao.BaseDao<LemonUser, String>) adLemonUserDao);
	}

	@Override
	public Pager getList(Pager pager) {
		return adLemonUserDao.getList(pager) ;
	}

}