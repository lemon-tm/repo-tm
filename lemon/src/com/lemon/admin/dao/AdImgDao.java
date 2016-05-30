package com.lemon.admin.dao;

import java.util.List;

import com.lemon.dao.BaseDao;
import com.lemon.entity.Img;
import com.lemon.entity.ImgHouse;
import com.lemon.entity.LemonUser;
import com.lemon.util.Pager;

/*
 *  @author 
 */
public interface AdImgDao extends BaseDao<Img, String>{

	Pager getList(Pager pager, LemonUser user, ImgHouse img);

	List<Img> getListBy(Img img);
	
}