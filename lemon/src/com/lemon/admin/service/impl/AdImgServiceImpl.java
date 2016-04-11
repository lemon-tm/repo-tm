package com.lemon.admin.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lemon.admin.dao.AdImgDao;
import com.lemon.admin.service.AdImgService;
import com.lemon.entity.ImgHouse;

/*
 *  @author 
 */
@Service
public class AdImgServiceImpl extends BaseServiceImpl<ImgHouse,String> implements AdImgService{

	@Resource
	private AdImgDao adImgDao;
	
	@Resource(name = "adImgDaoImpl")
	public void setBaseDao(AdImgDao adImgDao) {
		super.setBaseDao(adImgDao);
	}

	


	

}