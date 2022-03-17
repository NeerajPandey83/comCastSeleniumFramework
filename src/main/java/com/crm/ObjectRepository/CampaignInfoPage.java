package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CampaignInfoPage extends WebDriverUtility {
	
	//step 1 declaration

		@FindBy(xpath = "//span[@class='dvHeaderText']")
		private WebElement headerText;
		
		//step 2 initialization
		public  CampaignInfoPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//step 3: utilization
		
		public WebElement getHeaderText() {
			return headerText;
		}
		
		
		//business library
		public String campaignInfo()
		{
			String campaignInfo = headerText.getText();
			return campaignInfo;
			
		}
	

}
