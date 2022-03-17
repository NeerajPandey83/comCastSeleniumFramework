package com.crm.GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;

import com.mysql.cj.jdbc.Driver;


/**
 * This class contains generic method to read data from database
 * @author 91834
 *
 */
public class DataBaseUtility {
	Connection con = null;
	
	public void dataBase() throws Throwable
	{
		// Step 1: Register the database
		Driver driverRef = new Driver();
		
		// Step 2: getting connection to data base
		DriverManager.registerDriver(driverRef);
		Connection con = DriverManager.getConnection(IPathConstents.dbURL, IPathConstents.dbUSERNAME,IPathConstents.dbPASSWORD);
		
	}
	
	/**This method will close database connection
	 * 
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable
	{
		con.close();
	}
	

	public String executeQueryAndGetData(String query,int coulumnIndex,String expData) throws Throwable
	{
		String data = null;
		boolean flag = false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			data = result.getString(coulumnIndex);
			if(data.equalsIgnoreCase(expData))
			{
				flag = true;
			}
		}
		if(flag)
		{
			System.out.println(data + "......");
			return expData;
		}
		else {
			System.out.println("fdata not be created  ");
			return " ";
		}
	}
	
}
