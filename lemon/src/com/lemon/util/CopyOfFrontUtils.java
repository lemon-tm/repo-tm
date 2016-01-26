package com.lemon.util;

import javax.servlet.http.HttpServletRequest;

import static com.lemon.util.Constants.TPL_SUFFIX;

/**
 * 前台工具类
 */
public class CopyOfFrontUtils {
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
}
