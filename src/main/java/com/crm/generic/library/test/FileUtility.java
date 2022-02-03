package com.crm.generic.library.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility 
{
	public String getPropertyKeyValue(String Key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(".\\data\\commonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(Key);
		return value;
	}

}
