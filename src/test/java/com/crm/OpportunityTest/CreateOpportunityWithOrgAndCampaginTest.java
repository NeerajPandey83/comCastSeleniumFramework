package com.crm.OpportunityTest;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcleFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOpportunityWithOrgAndCampaginTest {
	@Test
	public void createOpportunityWithOrgAndCampaginTest() throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		
		/*read data*/
		PropertyFileUtility pLib = new PropertyFileUtility();
		JavaUtility jLib = new JavaUtility();
		ExcleFileUtility eLib = new ExcleFileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		/*Step 1: read all neccessary data*/
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		
		String campaignName = eLib.readDataFromExcle("Campaign", 1, 2)+"_"+jLib.getRandomNumber();
		String prodName = eLib.readDataFromExcle("Campaign", 1, 3)+"_"+jLib.getRandomNumber();
		String lastName = eLib.readDataFromExcle("Contacts", 1, 2)+"_"+jLib.getRandomNumber();
		String OpportunityName = eLib.readDataFromExcle("Opportunity", 1, 2)+"_"+jLib.getRandomNumber();
		
		
	
		/*Step 2: launch the browser*/
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser name");
		}
		
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		
		/* Step 3: login to the application*/
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		
		/*Step 4:Create campaign*/
		driver.findElement(By.xpath("//a[.='More']")).click();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campaignName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		/*Step 5:verify for campaign*/
		String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(header.contains(campaignName))
		{
			System.out.println(header);
			System.out.println("camp created");
		}
		else
		{
			System.out.println(header);
			System.out.println("camp not created");
		}
		
		/*step 4: navigate to contacts link*/
		driver.findElement(By.xpath("(//a[.='Contacts'])[1]")).click();
		
		/*step 5: create contacts link*/
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		/*step 6: create contacts with mandatory fields and save*/
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		/*Step 7:verify for contacts*/
		String headr = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headr.contains(lastName))
		{
			System.out.println(headr);
			System.out.println("contact created");
		}
		else
		{
			System.out.println(headr);
			System.out.println("contact not created");
		}
		
		/* Step 8: Navigate to opportunity link*/
		driver.findElement(By.xpath("(//a[.='Opportunities'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click(); 
		driver.findElement(By.name("potentialname")).sendKeys(OpportunityName);
		
		
		// campaign
		driver.findElement(By.xpath("(//img[@title='Select'])[2]")).click();
		Set<String> win = driver.getWindowHandles();
		for(String wh:win)
		{
			driver.switchTo().window(wh);
		}
		driver.findElement(By.name("search_text")).sendKeys(campaignName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.partialLinkText("Advert")).click();
		
		Set<String> whp = driver.getWindowHandles();
		for(String w1:whp)
		{
			driver.switchTo().window(w1);
		}
		
	
	}
	

}
