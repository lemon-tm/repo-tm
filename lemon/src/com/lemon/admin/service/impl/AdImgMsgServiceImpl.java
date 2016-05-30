package com.lemon.admin.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lemon.admin.dao.AdImgMsgDao;
import com.lemon.admin.service.AdImgMsgService;
import com.lemon.entity.Img;
import com.lemon.entity.ImgMsg;
import com.lemon.entity.LemonUser;
import com.lemon.service.impl.BaseServiceImpl;
import com.lemon.util.Pager;

/*
 *  @author 
 */
@Service
public class AdImgMsgServiceImpl extends BaseServiceImpl<ImgMsg,String> implements AdImgMsgService{

	@Resource
	private AdImgMsgDao adImgMsgDao;
	
	@Resource(name = "adImgMsgDaoImpl")
	public void setBaseDao(AdImgMsgDao adImgMsgDao) {
		super.setBaseDao(adImgMsgDao);
	}

	@Override
	public Pager getList(Pager pager, LemonUser user, Img img) {
		return adImgMsgDao.getList(pager, user, img);
	}

}