package com.crmPRACTICE;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcleFileUtility;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateNewContactPage;
import com.crm.ObjectRepository.HomePage;

@Listeners(com.crm.GenericLibrary.ListnersIplimentationClass.class)

public class TakeSchreenshot extends BaseClass
{
	
	
	@Test(retryAnalyzer = com.crm.GenericLibrary.RetryAnalyserImplimentation.class)
	public void createContactWithBaseClassTest() throws Throwable
	{
		// Read data from excel
		ExcleFileUtility eLib = new ExcleFileUtility();
		String lastName = eLib.readDataFromExcle("Contacts", 1, 2)+jLib.getRandomNumber();
		String orgName = eLib.readDataFromExcle("Org", 1, 2)+jLib.getRandomNumber();
		
		//Navigate to contact link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactLnk();
		
		//Create new contact
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContImg();
		
		// add mandatory field
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createNewContact(lastNam);
		
		//varification
		ContactInfoPage cip = new ContactInfoPage(driver);
		cip.contactNameInfo();
		
	}


	}


