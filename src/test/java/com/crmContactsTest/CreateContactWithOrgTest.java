package com.crmContactsTest;

import java.io.FileInputStream;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrgTest {
	@Test
	public void ctreateOrgTest() throws IOException {
		
		/* Generate random number*/
		Random ran = new Random();
		ran.nextInt(500);
		/* step 1: read all necessary data*/
		// read data from properties file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		//read the data from excle sheet
      FileInputStream f1 = new FileInputStream(".\\src\\test\\resources\\testData.xlsx");
      Workbook wb = WorkbookFactory.create(f1);
      Sheet sh = wb.getSheet("Org");
      Row row = sh.getRow(1);
      Cell cel = row.getCell(2);
      String OrgName = cel.getStringCellValue();
		System.out.println(OrgName);
		
		
		/*step 2: launch the browser*/
		
		WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("chrome")) 
		{   WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("invalid browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		
		/*step 3:login to Application*/
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		/*step 4: navigate to contacts link*/
		driver.findElement(By.xpath("(//a[.='Contacts'])[1]")).click();
		
		/*step 5: create contacts link*/
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		/*step 6: create contacts with mandatory fields and save*/
		driver.findElement(By.name("lastname")).sendKeys("NEERAJ");
	
		
		/*step 7: choose any existing org and save*/
		driver.findElement(By.xpath("(//img[@style='cursor:hand;cursor:pointer'])[1]")).click();
		Set<String> win = driver.getWindowHandles();
		for(String wh:win)
		{
			driver.switchTo().window(wh);
		}
		driver.findElement(By.name("search_text")).sendKeys(OrgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[.='ALL STATES']")).click();
		
		Set<String> whp = driver.getWindowHandles();
		for(String w1:whp)
		{
			driver.switchTo().window(w1);
		}
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	
		
		/* close the browser*/
		driver.quit();
	}
	

}

