package com.lemon.admin.service;

import com.lemon.entity.LemonUser;
import com.lemon.service.BaseService;
import com.lemon.util.Pager;

/*
 *  @author 
 */
public interface AdLemonUserService extends BaseService<LemonUser,String>{

	Pager getList(Pager pager);
	
}


