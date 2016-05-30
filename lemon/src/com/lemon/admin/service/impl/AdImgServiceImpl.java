package com.lemon.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lemon.admin.dao.AdImgDao;
import com.lemon.admin.service.AdImgService;
import com.lemon.entity.Img;
import com.lemon.entity.ImgHouse;
import com.lemon.entity.LemonUser;
import com.lemon.service.impl.BaseServiceImpl;
import com.lemon.util.Pager;

/*
 *  @author 
 */
@Service
public class AdImgServiceImpl extends BaseServiceImpl<Img,String> implements AdImgService{

	@Resource
	private AdImgDao adImgDao;
	
	@Resource(name = "adImgDaoImpl")
	public void setBaseDao(AdImgDao adImgDao) {
		super.setBaseDao(adImgDao);
	}

	@Override
	public Pager getList(Pager pager, LemonUser user, ImgHouse img) {
		return adImgDao.getList(pager, user, img) ;
	}


	@Override
	public List<Img> getListBy(Img img) {
		return adImgDao.getListBy(img);
	}

	


	

}