package com.crmPRACTICE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FireFoxTest {
	@Test
	public void firefox()
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("https://google.com");
		driver.quit();
	}

}
