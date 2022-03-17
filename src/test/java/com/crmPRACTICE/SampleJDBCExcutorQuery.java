package com.crmPRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExcutorQuery {
	@Test
	public void sampleJDBCExecutorQuery() throws SQLException {
		
		//step1- register the database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step2- get connection from database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root","root");
		
		//step 3 -issue create statement
		Statement state = con.createStatement();
		
		//step 4- execute query
		 ResultSet result = state.executeQuery("select * from student");
		 
		 while(result.next()) {
			 System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
		 }
		 
		 //close the database
		con.close();
		
		
	}
	

}
