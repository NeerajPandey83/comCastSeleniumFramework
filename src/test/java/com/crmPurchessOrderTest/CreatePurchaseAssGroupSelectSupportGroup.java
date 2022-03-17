package com.crmPurchessOrderTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreatePurchaseAssGroupSelectSupportGroup {
	@Test(groups = "smokeTest")
	public void createPurchaseAssGroupSelectSupportGroup() throws IOException {
	/*step 1: getting random number*/
	Random rn = new Random();
	int random = rn.nextInt(500);
	
	/*step 2: read all necessary data*/
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
	Properties pObj = new Properties();
	pObj.load(fis);
	String BROWS = pObj.getProperty("browser");
	String URL = pObj.getProperty("url");
	String UN = pObj.getProperty("username");
	String PWD = pObj.getProperty("password");
	
	
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
	
	/*step 6: purchase order select assign to Group*/
	driver.findElement(By.xpath("(//input[@onclick='toggleAssignType(this.value)'])[2]")).click();
	 WebElement ele = driver.findElement(By.name("assigned_group_id"));
	 Select s = new Select(ele);
	 s.selectByVisibleText("Support Group");
	
	/*step 7:logout*/
	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	
	/*close the browser*/
	driver.quit();
	
	
}

}



