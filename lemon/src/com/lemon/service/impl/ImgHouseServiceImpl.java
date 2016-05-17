package com.lemon.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lemon.dao.ImgHouseDao;
import com.lemon.entity.ImgHouse;
import com.lemon.service.ImgHouseService;
import com.lemon.util.Pager;

/*
 *  @author 
 */
@Service
public class ImgHouseServiceImpl extends BaseServiceImpl<ImgHouse,String> implements ImgHouseService{

	@Resource
	private ImgHouseDao imgHouseDao;
	
	@Resource(name = "imgHouseDaoImpl")
	public void setBaseDao(ImgHouseDao imgHouseDao) {
		super.setBaseDao(imgHouseDao);
	}

	public Pager findByUser(Pager page,String userId, ImgHouse img) {
		return imgHouseDao.findByUser(page, userId, img) ;
	}

	public Pager getList(Pager pager) {
		return imgHouseDao.getList(pager) ;
	}

}