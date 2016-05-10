package com.lemon.common.email.util;

import java.io.IOException;
import java.util.Properties;

public class PropertyUtilityForEmail {
	private static Properties properties = new Properties();

	static {
		try {
			properties.load(PropertyUtilityForEmail.class.getClassLoader()
					.getResourceAsStream("config/email.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String name) {
		return properties.getProperty(name);
	}
}

/*
 * Location:
 * E:\MyWork\亚洲财经\代码\apache-tomcat-7.0.57\webapps\af_thirdparty\WEB-INF\classes\
 * Qualified Name: com.af.property.PropertyUtility JD-Core Version: 0.6.2
 */