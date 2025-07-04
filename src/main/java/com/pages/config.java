package com.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class config {

	 private static Properties properties;

	public static Properties getproperty() {
		properties = new Properties();
		try {
			FileInputStream fil = new FileInputStream("./src/test/resources/driver_file/confi.properties");
			try {
				properties.load(fil);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return properties;

	}

}
