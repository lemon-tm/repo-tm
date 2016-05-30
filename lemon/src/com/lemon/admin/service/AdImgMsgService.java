package com.lemon.admin.service;

import com.lemon.entity.Img;
import com.lemon.entity.ImgMsg;
import com.lemon.entity.LemonUser;
import com.lemon.service.BaseService;
import com.lemon.util.Pager;

/*
 *  @author 
 */
public interface AdImgMsgService extends BaseService<ImgMsg,String>{

	Pager getList(Pager pager, LemonUser user, Img img);
	
}


