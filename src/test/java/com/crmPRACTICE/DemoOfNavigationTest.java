package com.crmPRACTICE;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DemoOfNavigationTest {
	
	@Test
	public void demoOfNavigationTest() throws Throwable
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://access-eu-qa-custom-zone01-front.azurewebsites.net/account/geolocation");
		 driver.findElement(By.xpath("//div[@class='selectInput']")).click();
		  
		
		 List<WebElement> alllist = driver.findElements(By.xpath("//ul[@class='dropdown_list']"));
		 
		 for(WebElement ab:alllist)
		 {
			String at = ab.getText();
			System.out.println(at);
		 }
		/*for(int i = 0;i<alllist.size();i++)
		{
			if(i==5)
			{
				 alllist.get(i).click();
			}
		}
		// ArrayList s =new ArrayList<String>();
		 
		 for(WebElement al:alllist)
		 {
			 Thread.sleep(3000);
			String value = al.getText();
			
			if(value.contains("ng"))
			{
				al.click();
				
			}
			break;
		 }*/
		 
		 
			 
		 }
	}

