package com.lemon.common.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;

import com.lemon.common.bean.ImageBean;
import com.lemon.common.service.ImageService;
import com.lemon.util.ImageUtil;

/*
 *  亚洲财经   -- http://www.asiafinance.cn
 *	Copyright ©2010-2014 亚洲财经网 All Rights Reserved 
 * 
 *  @author 
 */
@Service
public class ImageServiceImpl implements ServletContextAware, ImageService {

	private ServletContext servletContext;
	
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	/**
	 * 构建真相上传图片
	 * @param truthImageFile 图片名称
	 * @return
	 */

	public ImageBean buildImage(File imageFile) {
		ImageBean imageBean = new ImageBean();
		imageBean.setId(UUID.randomUUID().toString().replace("-", ""));
		imageBean.setPath(ImageBean.UPLOAD_PATH);
		imageBean.setSourceImageFormatName(ImageUtil.getFormatName(imageFile));
		File sourceImageFile = new File(servletContext.getRealPath(imageBean.getSourceImagePath()));
		File bigImageFile = new File(servletContext.getRealPath(imageBean.getBigImagePath()));
		File smallImageFile = new File(servletContext.getRealPath(imageBean.getSmallImagePath()));
		File thumbnailImageFile = new File(servletContext.getRealPath(imageBean.getThumbnailImagePath()));

		File sourceTruthImageParentFile = sourceImageFile.getParentFile();
		File bigTruthImageParentFile = bigImageFile.getParentFile();
		File smallTruthImageParentFile = smallImageFile.getParentFile();
		File thumbnailTruthImageParentFile = thumbnailImageFile.getParentFile();

		if (!sourceTruthImageParentFile.isDirectory()) {
			sourceTruthImageParentFile.mkdirs();
		}
		if (!bigTruthImageParentFile.isDirectory()) {
			bigTruthImageParentFile.mkdirs();
		}
		if (!smallTruthImageParentFile.isDirectory()) {
			smallTruthImageParentFile.mkdirs();
		}
		if (!thumbnailTruthImageParentFile.isDirectory()) {
			thumbnailTruthImageParentFile.mkdirs();
		}
		
		try {
			FileUtils.copyFile(imageFile, sourceImageFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ImageUtil.reduce(imageFile, bigImageFile, 300,300);  //大图缩放比例 300*300  自己根据需求调
		ImageUtil.reduce(imageFile, smallImageFile, 80, 80); //小图
		ImageUtil.reduce(imageFile, thumbnailImageFile, 160, 160); //中图
		
		return imageBean;
	}
	
	
}