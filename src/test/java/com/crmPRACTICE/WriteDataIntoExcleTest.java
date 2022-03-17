package com.crmPRACTICE;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import com.google.protobuf.DescriptorProtos.FileOptions;

public class WriteDataIntoExcleTest {
	@Test
	public void writeDataIntoExcleTest() throws IOException {
		
		//step 1: load excle file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		Row ro = sh.getRow(1);
		
		//create a cell
		Cell ce = ro.createCell(1);
		
		ce.setCellValue("tc_1000");
		
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\data.xlsx");
		wb.write(fos);
		
		
	}

}
