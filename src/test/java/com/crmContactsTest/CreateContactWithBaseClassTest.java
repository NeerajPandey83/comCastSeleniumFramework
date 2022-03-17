package com.crmContactsTest;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcleFileUtility;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateNewContactPage;
import com.crm.ObjectRepository.HomePage;

public class CreateContactWithBaseClassTest extends BaseClass{
	@Test
	public void createContactWithBaseClassTest() throws Throwable
	{
		// Read data from excel
		ExcleFileUtility eLib = new ExcleFileUtility();
		String lastName = eLib.readDataFromExcle("Contacts", 1, 2)+jLib.getRandomNumber();
		String orgName = eLib.readDataFromExcle("Org", 1, 2)+jLib.getRandomNumber();
		
		//Navigate to contact link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactLnk();
		
		//Create new contact
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContImg();
		
		// add mandatory field
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createNewContact(lastName);
		
		//varification
		ContactInfoPage cip = new ContactInfoPage(driver);
		cip.contactNameInfo();
		
	}

}
