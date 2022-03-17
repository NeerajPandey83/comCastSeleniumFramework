package com.crmOrganisationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcleFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationPage;

public class CreateOrgWithIndustryAndTypeDropDown {
	
	// create object for all utility
	PropertyFileUtility pLib = new PropertyFileUtility();
	ExcleFileUtility eLib = new ExcleFileUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	JavaUtility jLib = new JavaUtility();
	
	@Test
	public void createOrgWithIndustryAndTypeDropDown(String orgName, String indType, String TypeDropDown) throws Throwable
	{
		// read data
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		
		String orgName1= orgName+jLib.getRandomNumber();
		
		//Launch the browser
		WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		
		//Login to application
		LoginPage Ip = new LoginPage(driver);
		Ip.LoginToApp(USERNAME, PASSWORD);
		Reporter.log("login successfull",true);
		
		//Navigate to organization
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationlnk();
		Reporter.log("navigate to org link",true);
		
		
		//create Org
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOnCreateOrgImg();
		Reporter.log(" click on create org succesfully",true);
				
		//create New org
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createNewOrg(orgName, indType);
		Reporter.log("create org with industry type",true);
		
		//Validation
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actHeader = oip.orgNameInfo();
		if(actHeader.contains(orgName))
		{
			System.out.println("passed");
		}
		else
		{
			System.out.println("validation failed");
		}
		Reporter.log("varification  succesfull",true);
		
		hp.signOutOfApp(driver);
		driver.quit();
		
	}
	
	@DataProvider(name ="orgTestData")
	public Object[][] getData() throws Throwable
	{
		Object[][] data = eLib.readmultipleDataFromExcel("OrgMultipleData");
		return data;
	}

}
