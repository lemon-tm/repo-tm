package com.lemon.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;


import com.lemon.common.UploadUtils;
import com.lemon.common.bean.ImageBean;
import com.lemon.common.service.ImageService;
import com.lemon.entity.ImgHouse;
import com.lemon.entity.LemonUser;
import com.lemon.service.ImgHouseService;
import com.lemon.util.FrontUtils;
import com.lemon.util.ResponseUtils;

@Controller
public class UploadCor implements ServletContextAware {
	
	@Resource
	private ImageService imageService ;
	
	@Resource
	private ImgHouseService imgHouseService ;
	
	/**
	 * 操作
	 * 保存图片路径 
	 * 
	 */
	@RequestMapping(value="saveimg.jspx", method = RequestMethod.POST)
	public String saveUploadImg(String[] imgurl, HttpServletRequest request,HttpServletResponse response, ModelMap model){
		FrontUtils.frontData(request, model);
		
		ImgHouse imgHouse = new ImgHouse() ;
		
		LemonUser user = (LemonUser) request.getSession().getAttribute("user") ;
		
		if(null!=imgurl && imgurl.length>0){
			
			List<ImageBean> list = new ArrayList<ImageBean>();
			for(int i=0; i<imgurl.length; i++){
				String imgurlstr = imgurl[i];
				
				String a = request.getContextPath();//项目名称，如：/jeecms
				String path = request.getSession().getServletContext().getRealPath("/") ;//服务器路径，如：E://
				imgurlstr = path+imgurlstr ;//图片在服务器的全路径
				File file = new File(imgurlstr) ;
				ImageBean img = imageService.buildImage(file) ;
				list.add(img) ;
			}
			
			Collections.sort(list);
			JSONArray jsonArray = JSONArray.fromObject(list);
			String path = jsonArray.toString() ;
			imgHouse.setImgurl(path) ;
		}
		imgHouse.setUserId(user.getId()) ;
		imgHouse.setCreateTime(new Date()) ;
		imgHouse.setUploadTime(new Date()) ;
		imgHouse.setStatus(1) ;
		imgHouse.setName("后台假数据name") ;
		imgHouse.setDescribe("后台假数据describe") ;
		imgHouseService.save(imgHouse) ;
		model.put("imgHouse", imgHouse) ;
		return "/WEB-INF/jsp/ucenter/upload_d.jsp" ;
	}
	/**
	 * 跳转
	 * 到上传图片页面
	 *  
	 */
	@RequestMapping(value="tupload.jspx", method = RequestMethod.GET)
	public String toUploadImg(HttpServletRequest request,HttpServletResponse response, ModelMap model){
		FrontUtils.frontData(request, model);
		return "/WEB-INF/jsp/upload.jsp" ;
	}
	/**
	 * 操作
	 * 上传图片
	 * 使用MultipartFile需要在配置文件里配置
	 */
	@RequestMapping(value="upload.jspx", method = RequestMethod.POST)
	public void uploadImg(@RequestParam(value = "mediaFile") MultipartFile file,String filename, HttpServletRequest request,HttpServletResponse response, ModelMap model){
		
		
		String origName = file.getOriginalFilename();
		String ext = FilenameUtils.getExtension(origName).toLowerCase(
				Locale.ENGLISH);
		
		
		// TODO 检查允许上传的后缀
		String fileUrl="";
		try {
			fileUrl = storeByExt("/image/upload",
						ext, file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		//fileMng.saveFileByPath(fileUrl, fileUrl, false);
		model.addAttribute("mediaPath", fileUrl);
		model.addAttribute("mediaExt", ext);
		JSONObject json = new JSONObject();
		json.put("success", true);
		json.put("msg", fileUrl);
		ResponseUtils.render(response, "text/html", json.toString());
		
	}
	
	public String storeByExt(String path, String ext, MultipartFile file)
			throws IOException {
		String filename = UploadUtils.generateFilename(path, ext);
		File dest = new File(getRealPath(filename));
		dest = UploadUtils.getUniqueFile(dest);
		store(file, dest);
		return filename;
	}
	
	private void store(MultipartFile file, File dest) throws IOException {
		try {
			UploadUtils.checkDirAndCreate(dest.getParentFile());
			file.transferTo(dest);
		} catch (IOException e) {
			throw e;
		}
	}
	
	private ServletContext ctx;
	
	private String getRealPath(String name){
		String realpath=ctx.getRealPath(name);
		if(realpath==null){
			realpath=ctx.getRealPath("/")+name;
		}
		return realpath;
	}

	public void setServletContext(ServletContext servletContext) {
		this.ctx = servletContext;
	}
	
	
	
	
}
