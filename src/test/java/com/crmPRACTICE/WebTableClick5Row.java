package com.crmPRACTICE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.HomePage;

public class WebTableClick5Row extends BaseClass{
	
	@Test
	public void webTableClick5Row()
	{
WebDriverUtility wLib = new WebDriverUtility();
		
		HomePage hp =  new HomePage(driver);
		hp.clickOnContactLnk();
		
		   WebElement ckeckBox = driver.findElement(By.xpath("(//table/tbody/tr[*]/td[1]/input[@name='selected_id'])[5]"));
		     
		   ckeckBox.click();
		
		
		
	}

}
