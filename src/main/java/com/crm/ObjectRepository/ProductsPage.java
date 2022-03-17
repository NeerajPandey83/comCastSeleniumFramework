package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	//step 1: declaration
	
	@FindBy(linkText = "Products")
	private WebElement productsLnk;
	
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement createProductsLookUpImg;
	
	//Step 2: initialization
	
		public  ProductsPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//step 3:utilization

		public WebElement getProductsLnk() {
			return productsLnk;
		}

		public WebElement getCreateProductsLookUpImg() {
			return createProductsLookUpImg;
		}
		
		
		//step 4: business library
		
		public void clickOnCreateOrgImg()
		{
			createProductsLookUpImg.click();
		}



}
