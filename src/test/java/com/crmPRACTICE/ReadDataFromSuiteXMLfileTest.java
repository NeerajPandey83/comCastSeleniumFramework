package com.crmPRACTICE;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromSuiteXMLfileTest {
	@Test
	public void readDataFromSuiteXML(XmlTest xml) {
		
		String BROWSER = xml.getParameter("browser");
		String URL = xml.getParameter("url");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		
	}

}
