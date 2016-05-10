package com.lemon.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * 读取配置文件
 * 
 * @author DELL
 * 
 */
public class PropertyUtility {
	private static Properties properties = new Properties();
	static {
		String classPath = PropertyUtility.class.getClassLoader().getResource("").getPath();
		String configPath=classPath.substring(0,classPath.indexOf("class"));
		String path=null;
		try {
			path=new String(configPath.getBytes("UTF8"),"utf-8");
		} catch (UnsupportedEncodingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

				try {//E:/MyWork/亚洲财经/代码/Workspace/jeecms/
				properties.load(new FileInputStream(path+"config/jdbc.properties"));
//					properties.load(PropertyUtility.class.getClassLoader().getResourceAsStream("./config/jdbc.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private PropertyUtility() {
	}

	public static String getProperty(String name) {
		return properties.getProperty(name);
	}
	

	public static void main(String[] arg){
		
		
		System.out.println(PropertyUtility.getProperty("message.url"));
	}
	
}
