package com.lemon.dao;

import java.util.List;

import com.lemon.dao.BaseDao;
import com.lemon.entity.Img;
import com.lemon.entity.ImgMsg;
import com.lemon.util.Pager;

/*
 *  @author 
 */
public interface ImgMsgDao extends BaseDao<ImgMsg, String>{

	List<ImgMsg> getList();

	Pager findByUser(Pager page, String id, ImgMsg imgmsg);
	
}