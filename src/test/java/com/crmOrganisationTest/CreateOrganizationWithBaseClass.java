package com.crmOrganisationTest;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcleFileUtility;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationPage;

public class CreateOrganizationWithBaseClass extends BaseClass {
	
	@Test
	public void createOrganizationWithBaseClass() throws Throwable
	{
		
		// read data from excel
		ExcleFileUtility eLib = new ExcleFileUtility();
		String orgNmae = eLib.readDataFromExcle("Org", 1, 2)+jLib.getRandomNumber();
		
		// Navigate to organization link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationlnk();
		
		// create new organization
		OrganizationPage oip = new OrganizationPage(driver);
		oip.clickOnCreateOrgImg();
		
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createNewOrg(orgNmae);
		
		// verification
		OrganizationInfoPage op = new OrganizationInfoPage(driver);
		op.orgNameInfo();	
	
	}

}
