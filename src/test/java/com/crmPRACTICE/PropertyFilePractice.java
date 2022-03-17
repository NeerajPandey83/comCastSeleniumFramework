package com.crmPRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyFilePractice {
	@Test
	public void propertyFile() throws IOException {
		
		//step 1: read the file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		
		// step 2: create Obj of properties
		Properties pObj = new Properties();
		pObj.load(fis);
		
		// step 3: read the data
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		
	}
	

}
