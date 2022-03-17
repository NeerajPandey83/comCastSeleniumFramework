package com.crmCampaignTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateCampaignTest {
@Test
public void createCampaignTest() throws IOException {
	
	/* STEP 1: Ganerate random number*/
	Random ran = new Random();
	int random = ran.nextInt(600);
	
	/* STEP 2: read all necessary data*/
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
	Properties pObj = new Properties();
	pObj.load(fis);
	String BROWSER = pObj.getProperty("browser");
	String URL = pObj.getProperty("url");
	String USERNAME = pObj.getProperty("username");
	String PASSWORD = pObj.getProperty("password");
	
	FileInputStream f1 = new FileInputStream(".\\src\\test\\resources\\DATAtest.xlsx");
	Workbook wb = WorkbookFactory.create(f1);
	  Sheet si = wb.getSheet("Campaign");
	  Row r = si.getRow(1);
	  Cell ce = r.getCell(2);
	String campName = ce.getStringCellValue()+random;
	 Cell cll = r.getCell(3);
	String prodName = cll.getStringCellValue()+random;
	 
	 /*step 3: launch the browser*/
	 WebDriver driver = null;
	 
	 if(BROWSER.equalsIgnoreCase("chrome")) {
		 
		driver = new ChromeDriver();
	 }
	 else if(BROWSER.equalsIgnoreCase("firefox")) {
		 driver = new FirefoxDriver();
	 }
	 else {
		 System.out.println("invalid browser");
	 }
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(URL);
		
		/*step 4:login to Application*/
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		/*step 5: create product */
		driver.findElement(By.xpath("//a[.='Products']")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Product...\"]")).click();
		driver.findElement(By.name("productname")).sendKeys(prodName);
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		
		/* verify the product name*/
		String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(header.contains(prodName)) {
			System.out.println(header);
			System.out.println("product created");
		}
		else {
			System.out.println("product nor created");
		}
		
		/* create campaign*/
		
		driver.findElement(By.xpath("//a[.='More']")).click();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campName);
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		Set<String> wh = driver.getWindowHandles();
		for(String winh:wh) {
			driver.switchTo().window(winh);
		}
		driver.findElement(By.name("search_text")).sendKeys(prodName);
		driver.findElement(By.name("search")).click();
		
		driver.findElement(By.xpath("//a[text()='"+prodName+"']")).click();
		
		Set<String> w1 = driver.getWindowHandles();
	
	for(String win:w1) {
		driver.switchTo().window(win);
	}

	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	/* verify for campaign*/
	String campHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(campHeader.contains(campName)) {
		System.out.println(campName + ""+ "campaign created");
	}
	else {
		System.out.println("campaign not created");
	}
	
	
	/*logout and close the browser*/
	WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act = new Actions(driver);
	act.moveToElement(element).perform();
	
	driver.findElement(By.linkText("Sign Out")).click();
	driver.quit();
	
	
}

@Test
public void sampleTest()
{
	System.out.println("tset 00");}

@Test
public void sampleTest1()
{
	System.out.println("tset 01");
	}

@Test
public void sampleTest2()
{
	System.out.println("tset 02");}




}
