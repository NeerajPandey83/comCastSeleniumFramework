package com.crm.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewCampaignPage {
	// Declaration
	@FindBy(name = "campaignname")
	private WebElement campaignName;
	
	@FindBy(xpath = "//input[@value='T']")
	private WebElement userRadioOption;
	
	@FindBy(xpath = "//input[@value='U']")
	private WebElement groupRadioOption;
	

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	
	//utilization
	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getUserRadioOption() {
		return userRadioOption;
	}

	public WebElement getGroupRadioOption() {
		return groupRadioOption;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	
	
	//business library
	
	
	public void campaignName()
	{
		campaignName.sendKeys("Campaign");
		userRadioOption.click();
		saveBtn.click();
		
	}
	


}
