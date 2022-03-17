package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class OrganizationPage extends WebDriverUtility {
	
	/*step 1: declaration*/
	
	@FindBy(linkText="Organizations")
	public WebElement organizationsLnk;
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrgLookUpImg;
	
	//Step 2: initialization
	
	public  OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//step 3:utilization
	
	public WebElement getCreateOrgLookUpImg()
	{
		return getCreateOrgLookUpImg();
	}
	
	//step 4: business library
	
	public void clickOnCreateOrgImg()
	{
		createOrgLookUpImg.click();
	}

}
