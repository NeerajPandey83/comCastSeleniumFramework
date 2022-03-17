package com.crmPRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {


	@Test
	
public void sampleJDBCExecuteUpdate() throws SQLException {
		Connection con = null;
	try {
		
	
    //step1- register the database
	Driver driverRef = new Driver();
	
	//step2- get connection from database
	DriverManager.registerDriver(driverRef);
	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
	
	//step 3 -issue create statement
	Statement state = con.createStatement();
	
	//step 4- execute query
	int result = state.executeUpdate("insert into students values('3','Adarsh','male')");
	if(result==1) {
		System.out.println("data added sucessfully");
	}
	else 
	{
		System.out.println("data not added");
	}
	}
	
	catch(Exception e) 
	{
		
	}
	
finally 
{
	//close the database
    
	con.close();
     System.out.println("connection closed");
}

	}
}
