package com.crmPRACTICE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class POMpracticeForLogin {
	
	@Test
	public void pomPractice()
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8888/d");
		
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp("admin", "admin");
		
		HomePage hp = new HomePage(driver);
		hp.clickOnContactLnk();
		hp.signOutOfApp(driver);
	}
	

}
