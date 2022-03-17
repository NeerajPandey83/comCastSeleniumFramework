package com.crmOrganisationTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hpsf.Property;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationPage;

public class CreateOrgTest extends BaseClass {
	
	
	@Test
	public void ctreateOrgTest() throws IOException {

		
		//read the data from excle sheet
         FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\testData.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Org");
		Row ro = sh.getRow(1);
		Cell ch = ro.getCell(2);
		String OrgName = ch.getStringCellValue();
		String industryType = sh.getRow(4).getCell(3).getStringCellValue();
		
		System.out.println(OrgName);
		
		
		/*step 4: navigate to organization link*/
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationlnk();


		
		/*step 5: create organization link*/
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOnCreateOrgImg();
		
		/*step 6: create org with mandatory fields and save*/
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createNewOrg(OrgName,industryType);
		
		
		/*verification*/
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.orgNameInfo();
		if(actOrgName.contains(OrgName))
		{
			System.out.println(actOrgName+"-------> data varified");
		}
		else
		{
			System.out.println("data invalid");
		}
	
		
	}		
	}