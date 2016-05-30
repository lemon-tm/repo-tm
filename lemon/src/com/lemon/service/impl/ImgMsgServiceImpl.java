package com.lemon.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.lemon.service.impl.BaseServiceImpl;
import com.lemon.dao.ImgMsgDao;
import com.lemon.entity.ImgMsg;
import com.lemon.service.ImgMsgService;

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

}