package com.lemon.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.lemon.service.impl.BaseServiceImpl;
import com.lemon.dao.PropertiesDao;
import com.lemon.entity.Properties;
import com.lemon.service.PropertiesService;

/*
 *  @author 
 */
@Service
public class PropertiesServiceImpl extends BaseServiceImpl<Properties,String> implements PropertiesService{

	@Resource
	private PropertiesDao propertiesDao;
	
	@Resource(name = "propertiesDaoImpl")
	public void setBaseDao(PropertiesDao propertiesDao) {
		super.setBaseDao(propertiesDao);
	}

}