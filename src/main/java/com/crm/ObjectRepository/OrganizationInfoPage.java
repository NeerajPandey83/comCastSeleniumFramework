package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class OrganizationInfoPage extends WebDriverUtility {
	//step 1 declaration

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	//step 2 initialization
	public  OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//step 3: utilization
	
	public WebElement getHeaderText() {
		return headerText;
	}
	
	public String orgNameInfo()
	{
		String orgInfo = headerText.getText();
		return orgInfo;
		
	}

}
