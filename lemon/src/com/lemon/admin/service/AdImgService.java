package com.lemon.admin.service;

import com.lemon.entity.ImgHouse;
import com.lemon.entity.LemonUser;
import com.lemon.service.BaseService;
import com.lemon.util.Pager;

/*
 *  @author 
 */
public interface AdImgService extends BaseService<ImgHouse,String>{

	Pager getList(Pager pager, LemonUser user, ImgHouse img);

}


