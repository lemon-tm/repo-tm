package com.lemon.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.lemon.service.impl.BaseServiceImpl;
import com.lemon.dao.ImgDao;
import com.lemon.entity.Img;
import com.lemon.service.ImgService;
import com.lemon.util.Pager;

/*
 *  @author 
 */
@Service
public class ImgServiceImpl extends BaseServiceImpl<Img,String> implements ImgService{

	@Resource
	private ImgDao imgDao;
	
	@Resource(name = "imgDaoImpl")
	public void setBaseDao(ImgDao imgDao) {
		super.setBaseDao(imgDao);
	}

	@Override
	public List<Img> getListBy(String relationId) {
		return imgDao.getListBy(relationId);
	}

	@Override
	public Pager getList(Pager pager, String keywords, String category) {
		return imgDao.getList(pager, keywords, category);
	}

	@Override
	public List<Img> getListBy(Img img) {
		return imgDao.getListBy(img);
	}

}