package com.crm.GenericLibrary;

import java.sql.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	//create object of all utility
	public WebDriverUtility wLib = new WebDriverUtility();
	public ExcleFileUtility eLib = new ExcleFileUtility();
	public PropertyFileUtility pLib = new PropertyFileUtility();
	public JavaUtility jLib = new JavaUtility();
	public DataBaseUtility dbLib = new DataBaseUtility();
	public WebDriver driver;
	
	/*add static webdriver in base class*/
	  
	  public static WebDriver sDriver;
	  
	
	@BeforeSuite(groups = {"smokeTest","regrassionTest"})
	public void connectDataBase()
	{
		//dbLib.connectToDb();
		Reporter.log("====db connection successfull==",true);
	}
	
	@BeforeClass(groups = {"smokeTest","regrassionTest"})
	//@Parameters("browser")
	//@BeforeTest
	public void launchTheBrowser(/*String BROWSER*/) throws Throwable
	{
		// read the data from property file
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else
		{
			System.out.println("===invalid browser===");
		}
	
		sDriver = driver;
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		Reporter.log("===browser launch successfull===",true);
	}
	
	
		@BeforeMethod(groups = {"smokeTest","regrassionTest"})
		public void login() throws Throwable
		{
			String USERNAME = pLib.readDataFromPropertyFile("username");
			String PASSWORD = pLib.readDataFromPropertyFile("password");
			LoginPage lp = new LoginPage(driver);
			lp.LoginToApp(USERNAME, PASSWORD);
			Reporter.log("===Login successfull===",true);
		}
		
		@AfterMethod(groups = {"smokeTest","regrassionTest"})
		public void logout()
		{
			HomePage hp = new HomePage(driver);
			hp.signOutOfApp(driver);
			Reporter.log("==browser logout successfull===",true);
		}
		//@AfterTest
		@AfterClass(groups = {"smokeTest","regrassionTest"})
		public void closeBrowser()
		{
			driver.quit();
			Reporter.log("===browser close successfull===",true);
		}
		
		
		@BeforeSuite(groups = {"smokeTest","regrassionTest"})
		public void closeDb()
		{
			//dbLib.closeDB();
			Reporter.log("===Database close successfull===",true);
			}
		
		
		}
		
		
		
		



