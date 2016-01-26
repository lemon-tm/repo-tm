package com.lemon.common.service;

import java.io.File;

import com.lemon.common.bean.ImageBean;

public interface ImageService{

	/**
	 * 构建真相上传图片
	 * @param truthImageFile 图片名称
	 * @return
	 */
	public abstract ImageBean buildImage(File imageFile) ;

}