package com.crmPRACTICE;

import org.testng.annotations.Test;

public class ReadDataFromComndLineTest {
	@Test
	public void readDataFromComndLine() {
		String BROWSER = System.getProperty("browser");
		String URL = System.getProperty("url");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		
		System.out.println("browser name is----"+BROWSER);
		System.out.println("urk name is----"+URL);
		System.out.println("user name is----"+USERNAME);
		System.out.println("password is----"+PASSWORD);
	}
}
