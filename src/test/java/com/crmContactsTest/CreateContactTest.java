package com.crmContactsTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
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
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateContactTest {
	@Test
	public void ctreateOrgTest() throws IOException {
		
		/* Generate random number*/
		Random ran = new Random();
		ran.nextInt(500);
		
		
		//Assert.fail();
		
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		//read the data from excle sheet
         FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Org");
		Row ro = sh.getRow(1);
		Cell ch = ro.getCell(2);
		String OrgName = ch.getStringCellValue();
		
		System.out.println(OrgName);
		
		
		/*step 2: launch the browser*/
		
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
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		/* close the browser*/
		driver.quit();
	}

		
		

}
