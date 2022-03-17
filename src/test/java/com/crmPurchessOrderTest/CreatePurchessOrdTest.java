package com.crmPurchessOrderTest;

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

import com.mysql.cj.jdbc.Driver;

public class CreatePurchessOrdTest {
	@Test(groups = "smokeTest")
	public void createPurchessOrdTest() throws IOException  {
		/*step 1:create random number*/
		Random ran = new Random();
		int random = ran.nextInt(500);
		
		/*step 2: read all necessary data*/
		//read data from property file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties pOb = new Properties();
		pOb.load(fis);
		String BROWS = pOb.getProperty("browser");
		String URL = pOb.getProperty("url");
		String UN = pOb.getProperty("username");
		String PWD = pOb.getProperty("password");
		
		
	/*step 2: launch the browser*/
		WebDriver driver = null;
		if(BROWS.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		}
		else if(BROWS.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("invalid driver");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(URL);
		
		/*step 4:login to Application*/
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		
		/*step 5:create purchase order*/
		driver.findElement(By.xpath("//a[.='More']")).click();
		driver.findElement(By.name("Purchase Order")).click();
		driver.findElement(By.xpath("//img[@title='Create Purchase Order...']")).click();
		
		/*step 6: purchase order select assign to user*/
		driver.findElement(By.xpath("//input[@onclick='toggleAssignType(this.value)']")).click();
		
		/*step 7:logout*/
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
		/*close the browser*/
		driver.quit();
		
		
		
		
		
		
		
		
		
	}

}
