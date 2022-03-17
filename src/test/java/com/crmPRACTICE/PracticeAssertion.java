package com.crmPRACTICE;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.GenericLibrary.BaseClass;

public class PracticeAssertion extends BaseClass{
	
	@Test
	public void practiceAssertion() {
		
		SoftAssert sa = new SoftAssert();
		
		System.out.println("test-01 pass");
		sa.assertEquals(true, false);
		System.out.println("test-02 pass");
		Assert.assertEquals(false, true);
		System.out.println("test-03 failed");
		sa.assertAll();
				
	}

}
