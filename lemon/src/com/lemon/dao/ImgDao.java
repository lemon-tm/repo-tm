package com.lemon.dao;

import java.util.List;

import com.lemon.dao.BaseDao;
import com.lemon.entity.Img;
import com.lemon.util.Pager;

/*
 *  @author 
 */
public interface ImgDao extends BaseDao<Img, String>{

	List<Img> getListBy(String relationId);

	Pager getList(Pager pager, String keywords);
	
}