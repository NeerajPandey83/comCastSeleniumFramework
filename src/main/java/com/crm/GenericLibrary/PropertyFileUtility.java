package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author 91834
 *
 */
public class PropertyFileUtility {
	
	/**
	 * this is read data from property file and return data it to user
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile(String key) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstents.FilePath);
		Properties pLib = new Properties();
		pLib.load(fis);
		 String value = pLib.getProperty(key);
		 return value;
		
	}

}
