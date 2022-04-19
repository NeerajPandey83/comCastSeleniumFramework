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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ListnersIplimentationClass implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {

		String MethodName = result.getMethod().getMethodName();
		test = report.createTest(MethodName);
		
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
	    test.log(Status.PASS, MethodName+"------>passed");
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
		String path2 = desc.getAbsolutePath();
		
		try
		{  
			
			FileUtils.copyFile(scrFile,desc);
		}
		catch(IOException e)
		{
				
		}
		
		test.log(Status.FAIL,failTestName+"---->falied");
		//it will capture the expectation and log it in the report
		test.log(Status.FAIL,result.getThrowable());
		test.addScreenCaptureFromPath(path2);
		
		
		
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
		test.log(Status.SKIP,MethodName+"--->skipped");
		// it will capture the exception and log it in the report
		test.log(Status.SKIP,result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onStart(ITestContext context) {
		// Execution will start here
		/*Configure the report*/
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReports/extentreport"+new JavaUtility().getSystemDateFormate()+".html");
		htmlReport.config().setDocumentTitle("SDET-30 Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Selenium Execution Report");
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Browser", "Chrome");
		report.setSystemInfo("OS", "windows");
		report.setSystemInfo("base-url","https://localhost:8888");
		report.setSystemInfo("Reporter Name","Narayan");
	
		
	}

	public void onFinish(ITestContext context) {
		// consolidate all the parameters and generate the report
		report.flush();
		
	}



}