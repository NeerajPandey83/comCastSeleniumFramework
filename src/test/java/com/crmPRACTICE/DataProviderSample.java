package com.crmPRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderSample {
	@Test(dataProvider = "getData")
	public void dataProviderSample(String name, int num)
	{
		System.out.println(name+"---"+num);
	}
	
	@DataProvider Object[][] getData()
	{
		Object[][] obj = new Object[6][2];
		
		obj[0][0] = "Cricket";
		obj[0][1] = 11;
		
		obj[1][0] = "Basketball";
		obj[1][1] = 5;
		
		obj[2][0] = "Vollyvall";
		obj[2][1] = 9;
		
		obj[3][0] = "TableTennis";
		obj[3][1] = 2;
		
		obj[4][0] = "Kabbadi";
		obj[4][1] = 6;
		
		obj[5][0] = "FootBall";
		obj[5][1] = 11;
		return obj;
	
		
	}

}
