package com.lemon.admin.service;

import java.util.List;

import com.lemon.entity.Img;
import com.lemon.entity.ImgHouse;
import com.lemon.entity.LemonUser;
import com.lemon.service.BaseService;
import com.lemon.util.Pager;

/*
 *  @author 
 */
public interface AdImgService extends BaseService<Img,String>{

	Pager getList(Pager pager, LemonUser user, ImgHouse img);

	List<Img> getListBy(Img img);

}


