package com.crmPRACTICE;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PracticesBaseClass {
	
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("database connectivity establish");
	}
	
	@BeforeMethod
	public void bmConfig()
	{
		System.out.println("login to application");
	}
	
	@Test
	public void testCase()
	{
		System.out.println("test case");
	}

	@AfterMethod
	public void amConfig()
	{
		System.out.println("logout");
	}
	
	@AfterSuite
	public void asConfig()
	{
		System.out.println("disconnect database connection");
	}
}
