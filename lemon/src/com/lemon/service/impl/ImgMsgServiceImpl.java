package com.lemon.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.lemon.dao.ImgMsgDao;
import com.lemon.entity.ImgMsg;
import com.lemon.service.ImgMsgService;
import com.lemon.util.Pager;

/*
 *  @author 
 */
@Service
public class ImgMsgServiceImpl extends BaseServiceImpl<ImgMsg,String> implements ImgMsgService{

	@Resource
	private ImgMsgDao imgMsgDao;
	
	@Resource(name = "imgMsgDaoImpl")
	public void setBaseDao(ImgMsgDao imgMsgDao) {
		super.setBaseDao(imgMsgDao);
	}

	@Override
	public List<ImgMsg> getList() {
		return imgMsgDao.getList();
	}

	@Override
	public Pager findByUser(Pager page, String id, ImgMsg imgmsg) {
		// TODO Auto-generated method stub
		return imgMsgDao.findByUser(page,id,imgmsg) ;
	}

	@Override
	@Cacheable(value = "imgMsgList")
	public void getAllListby() {
		imgMsgDao.getAllList() ;
	}

}