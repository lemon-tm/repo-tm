package com.lemon.util;

import static com.lemon.util.Constants.TPL_SUFFIX;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.LocaleEditor;
import org.springframework.context.MessageSource;
import org.springframework.ui.ModelMap;

import com.lemon.entity.Properties;
import com.lemon.service.PropertiesService;

/**
 * 前台工具类
 */
public class FrontUtils {

	/**
	 * 部署路径
	 */
	public static final String BASE = "base";
	public static final String TITLE = "webtitle";
	public static final String KEYWORDS = "webkeywords";
	public static final String DESCRIPTION = "webdescription";
	

	/**
	 * 获得模板路径。将对模板文件名称进行本地化处理。
	 * 
	 * @param request
	 * @param solution
	 *            方案路径
	 * @param dir
	 *            模板目录。不本地化处理。
	 * @param name
	 *            模板名称。本地化处理。
	 * @return
	 */
	public static String getTplPath(HttpServletRequest request,
			String solution, String dir, String name) {
		return solution + "/" + dir + "/"
				+ MessageResolver.getMessage(request, name) + TPL_SUFFIX;
	}

	/**
	 * 获得模板路径。将对模板文件名称进行本地化处理。
	 * 
	 * @param messageSource
	 * @param lang
	 *            本地化语言
	 * @param solution
	 *            方案路径
	 * @param dir
	 *            模板目录。不本地化处理。
	 * @param name
	 *            模板名称。本地化处理。
	 * @return
	 */
	public static String getTplPath(MessageSource messageSource, String lang,
			String solution, String dir, String name) {
		LocaleEditor localeEditor = new LocaleEditor();
		localeEditor.setAsText(lang);
		Locale locale = (Locale) localeEditor.getValue();
		return solution + "/" + dir + "/"
				+ messageSource.getMessage(name, null, locale) + TPL_SUFFIX;
	}

	/**
	 * 获得模板路径。不对模板文件进行本地化处理。
	 * 
	 * @param solution
	 *            方案路径
	 * @param dir
	 *            模板目录。不本地化处理。
	 * @param name
	 *            模板名称。不本地化处理。
	 * @return
	 */
	public static String getTplPath(String solution, String dir, String name) {
		return solution + "/" + dir + "/" + name + TPL_SUFFIX;
	}

	public static void frontData(HttpServletRequest request, Map<String, Object> map) {
		String ctx = request.getContextPath() ;
		map.put(BASE, ctx);
	}

	public static void frontData(HttpServletRequest request, Map<String, Object> map, 
			PropertiesService propertiesService) {
		String ctx = request.getContextPath() ;
		map.put(BASE, ctx);
		//获取t./d./k./,现在没用上service没注入进来
		try {
			Properties proper = propertiesService.getAllList().get(0) ;
			map.put(TITLE, proper.getWebTitle()) ;
			map.put(KEYWORDS, proper.getWebKeywords()) ;
			map.put(DESCRIPTION, proper.getWebDescription()) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
