package com.lemon.service;

import java.util.List;

import com.lemon.service.BaseService;
import com.lemon.util.Pager;
import com.lemon.entity.Img;

/*
 *  @author 
 */
public interface ImgService extends BaseService<Img,String>{

	List<Img> getListBy(String relationId);

	Pager getList(Pager pager, String keywords, String category);
	
}


