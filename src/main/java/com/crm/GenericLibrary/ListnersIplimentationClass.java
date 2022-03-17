package com.crm.GenericLibrary;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;

public class ListnersIplimentationClass implements ITestListener {

	public void onTestStart(ITestResult result) {

		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName + "--- testscript execution started");
		
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName + "--- testscript execution sucessfull - PASS");
		
	}

	public void onTestFailure(ITestResult result) 
	{
		String failTestName=result.getMethod().getMethodName();
		Reporter.log("test script faield",true);
		
	    EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
		File scrFile = eDriver.getScreenshotAs(OutputType.FILE);
		//String Browser = result.getParameters(BROSWER);
		String sdate =new Date().toString().replace(":", "-").replace(" ", "-");
		File  desc=new File("./ScreenShort/"+failTestName+"-"+sdate+".png");
		
		try
		{  
			
			FileUtils.copyFile(scrFile,desc);
		}
		catch(IOException e)
		{
				
		}
//		test.log(Status.FAIL,result.getMethod().getMethodName()+"Failed");
//		test.log(Status.FAIL, result.getThrowable());
//		//test.addScreenCaptureFromPath(desc.getAbsolutePath());
//		try {
//			test.addScreencastFromPath(desc.getAbsolutePath());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		  
//	}
//		String MethodName = result.getMethod().getMethodName()+"-";
//		Reporter.log(MethodName + "--- TestScript Failed",true);
//		
//		//Step 1: Configure screenshot name
//		String screenshotName = MethodName+new JavaUtility().getSystemDateFormate();
//		System.out.println(screenshotName);
//		
//		//Step 2: using screenshot method from webDriver Utility
//		try {
//			
//			//new WebDriverUtility().takeScreenshot(BaseClass.sDriver, screenshotName);
//			
//	
//			//EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
//			//File src = eDriver.getScreenshotAs(OutputType.FILE);
//			//String pa = System.getProperty("user.dir")+"/ScreenShots/"+screenshotName+".PNG";
//			String path = "./Screenshots/"+screenshotName+".png";
//			File dst = new File(pa);
//			Files.copy(src, dst);
//			
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName + "--- TestScript Skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}



}