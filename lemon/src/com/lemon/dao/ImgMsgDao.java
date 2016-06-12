package com.lemon.dao;

import java.util.List;

import com.lemon.dao.BaseDao;
import com.lemon.entity.Img;
import com.lemon.entity.ImgMsg;

/*
 *  @author 
 */
public interface ImgMsgDao extends BaseDao<ImgMsg, String>{

	List<ImgMsg> getList();
	
}