package com.crmPRACTICE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class BookIndigoFlight {

	@Test
	public void bookIndigoFlight()
	{
		//ChromeOptions option = new ChromeOptions();
		//option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goindigo.in/");
		driver.manage().deleteAllCookies();
		driver.findElement(By.xpath("//label[.='Round Trip']")).click();
		driver.findElement(By.xpath("(//div[@class='airport-city'])[1]"));
		
	}
}
