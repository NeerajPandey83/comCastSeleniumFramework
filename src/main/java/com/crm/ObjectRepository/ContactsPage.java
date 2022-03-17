package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class ContactsPage extends WebDriverUtility {
	
	// Declaration
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createContactLookUpImg;
	
	//initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//getting getter
	public WebElement getCreateContactLookUpImg() {
		return createContactLookUpImg;
	}
	

	//business library
	public void clickOnCreateContImg()
	{
		createContactLookUpImg.click();
	}
	

}
