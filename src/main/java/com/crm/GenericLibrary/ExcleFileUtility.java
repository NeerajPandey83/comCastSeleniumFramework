package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.protobuf.DescriptorProtos.FileOptions;

/**
 * this method will read data from excle sheet and return the value when sheetname , row no, and cell number is s[ecofied
 * @author 91834
 *
 */
public class ExcleFileUtility {
	
	/**
	 * this method will read the data from excel sheet and return the value when  sheet name, row no and cell number specified
	 * @param SheetName
	 * @param rowNo
	 * @param celNo
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcle(String SheetName,int rowNo,int celNo) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstents.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row row = sh.getRow(rowNo);
		Cell cel = row.getCell(celNo);
		String value = cel.getStringCellValue();
		return value;
		
	}
	
	/**
	 * this method will write the data into excel sheet
	 * @param SheetName
	 * @param rowNo
	 * @param celNo
	 * @throws Throwable
	 */
	 
	public void writeDataFromExcel(String SheetName,int rowNo,int celNo) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstents.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row row = sh.getRow(rowNo);
		Cell cel = row.getCell(celNo);
		String value = cel.getStringCellValue();
		FileOutputStream fos = new FileOutputStream(SheetName);
		wb.write(fos);
	}
	
	/**
	 * this method will return last row number
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String SheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstents.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int row = sh.getLastRowNum();
		return row;
		
	}
	
	
	/**
	 * This method will read multiple data from excel sheet with the help of sheetname
	 * and return 2 dimensional object [][]
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][] readmultipleDataFromExcel(String SheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstents.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCell];
		
		for(int i = 0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
	
	}

}
