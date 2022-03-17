package com.crmOrganisationTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CreateOrganizationTest {
	@Test
	public void createOrganizationTest() throws IOException {
		/*step 1: take random number*/
		Random rn = new Random();
		int rndm = rn.nextInt(500);
		
		/*step 2: read all necessary data*/
		//read data from property file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String UN = pObj.getProperty("username");
		String PWD = pObj.getProperty("password");
		
		//read data from excle sheet
		FileInputStream f1 = new FileInputStream(".\\src\\test\\resources\\data.xlsx");
		Workbook wb = WorkbookFactory.create(f1);
		String state = wb.getSheet("Sheet1").getRow(2).getCell(1).getStringCellValue();
		
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
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		/*step 4: login the application*/
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		
		/**/
	
	}

}
