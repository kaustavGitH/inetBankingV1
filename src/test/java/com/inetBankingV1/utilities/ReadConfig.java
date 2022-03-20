package com.inetBankingV1.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties property;
	
	public ReadConfig()
	{
		File src=new File("./Configuration\\config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			property=new Properties();
			property.load(fis);
		} catch (Exception e) {
			System.out.println("File not found");;
		}
	}
	public String getBaseURL()
	{
		String url=property.getProperty("baseURL");
		return url;
	}
	public String getUserName()
	{
		String uname=property.getProperty("username");
		return uname;
	}
	public String getPassword()
	{
		String pword=property.getProperty("password");
		return pword;
	}
	public String getChromePath()
	{
		String chromePath=property.getProperty("chromePath");
		return chromePath;
	}
	
	public String getFirefoxPath()
	{
		String firefoxPath=property.getProperty("firefoxPath");
		return firefoxPath;
	}

}
