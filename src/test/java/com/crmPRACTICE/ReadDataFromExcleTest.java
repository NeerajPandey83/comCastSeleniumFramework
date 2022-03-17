package com.crmPRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadDataFromExcleTest {
	
	@Test
	public void readDataFromExcleTest() throws IOException {
		
		//step 1: load excle file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\data.xlsx");
		
		//step 2: create workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//step 3:get the sheet
		Sheet sh = wb.getSheet("Sheet1");
		
		//step 4: get the row
		Row ro = sh.getRow(0);
		
		//step 5: get the shell
		Cell ch = ro.getCell(1);
		
		//step 6: read the data from the cell
		String value = ch.getStringCellValue();
		
		System.out.println(value);
		
		
		
	}
	

}
