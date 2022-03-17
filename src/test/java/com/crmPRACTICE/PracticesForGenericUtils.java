package com.crmPRACTICE;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;

public class PracticesForGenericUtils {
	@Test
	public void practice() throws Throwable {
		JavaUtility jLib = new JavaUtility();
		int ran = jLib.getRandomNumber();
		String dat = jLib.getSystemDateFormate();
		String date = jLib.getDate();
		System.out.println(ran + date);
		System.out.println(dat);
		
		PropertyFileUtility pLib = new PropertyFileUtility();
		String brows = pLib.readDataFromPropertyFile("browser");
		System.out.println(brows);
		
		
	}

}
