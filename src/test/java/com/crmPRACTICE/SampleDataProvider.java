package com.crmPRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleDataProvider {
	@Test(dataProvider = "getData")
	public void sampleDataProvider(String name, String model, int qty)
	{
		System.out.println(name+"---"+model+"---"+qty);
	}

	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj= new Object[4][3];
		
		obj[0][0] = "Mi";
		obj[0][1]="13 Max Pro";
		obj [0][2] = 30;
		
		obj[1][0] = "One+";
		obj[1][1]="Note 5";
		obj [1][2] = 14;
		
		obj[2][0] = "SAMSUNG";
		obj[2][1]="A88";
		obj [2][2] = 21;
		
		obj[3][0] = "iPhone";
		obj[3][1]="13 note";
		obj [3][2] = 28;
		return obj;
	}
}
