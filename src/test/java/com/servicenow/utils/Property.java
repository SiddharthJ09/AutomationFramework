package com.servicenow.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Property {

	public static String get(String propertyname) throws IOException {

		FileReader reader = new FileReader("resources/application_config.properties");

		Properties properties = new Properties();
		properties.load(reader);
		return (String) properties.get(propertyname);
	}

}
