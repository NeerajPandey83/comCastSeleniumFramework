package com.crmPRACTICE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.HomePage;

public class WebTablePractice extends BaseClass{
	@Test
	public void webTablePractice() throws Throwable
	{
		WebDriverUtility wLib = new WebDriverUtility();
		
		HomePage hp =  new HomePage(driver);
		hp.clickOnContactLnk();
		
		 List<WebElement> ckeckBox = driver.findElements(By.xpath("//table/tbody/tr[*]/td[1]/input[@name='selected_id']"));
		 int count = ckeckBox.size();
		
		 for(WebElement check:ckeckBox)
		 {
			 check.click();
			 Reporter.log("all checkbox selected",true);
		 }
		
		 
		
		
	}

}
