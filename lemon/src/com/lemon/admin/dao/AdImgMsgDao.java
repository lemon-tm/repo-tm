package com.lemon.admin.dao;

import com.lemon.dao.BaseDao;
import com.lemon.entity.Img;
import com.lemon.entity.ImgMsg;
import com.lemon.entity.LemonUser;
import com.lemon.util.Pager;

/*
 *  @author 
 */
public interface AdImgMsgDao extends BaseDao<ImgMsg, String>{

	Pager getList(Pager pager, LemonUser user, Img img);
	
}