package com.crmPRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DataVerification {
	@Test
	public void dataVerification() throws SQLException {
		
		// expected data
		String expData = "MAHESH";
		
		//register the database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//get connection from database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root","root");
		
		//issue create statement
		Statement state = con.createStatement();
		
		//execute query
		ResultSet result = state.executeQuery("select * from student");
		while(result.next())
		{
			String actData = result.getString(2);
			
			if(expData.equalsIgnoreCase(actData)) {
				
				System.out.println(actData +"matching");
				
			}
			else 
			{
				System.out.println("not matching");
			}
		}
		
		con.close();
		
	}

}
