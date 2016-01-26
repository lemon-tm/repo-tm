package com.lemon.util;

import static com.lemon.util.Constants.TPL_SUFFIX;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.LocaleEditor;
import org.springframework.context.MessageSource;

/**
 * 前台工具类
 */
public class FrontUtils {
	
	/**
	 * 部署路径
	 */
	public static final String BASE = "base";
	

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

}
