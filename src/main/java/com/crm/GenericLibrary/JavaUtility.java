package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
/**
 * this class will use for genaric utils
 * @author 91834
 *
 */

public class JavaUtility {
	private Object time;

	/**
	 * this method will ganerate random number and return it to the user
	 * @return
	 */
	public int getRandomNumber() {
		Random ran = new Random();
		int random = ran.nextInt(500);
		return random;
	}
	
	/**
	 * this method use to generate current system date and return it to the user
	 * @return
	 */
	public String getDate() {
		Date d= new Date();
		String date = d.toString();
		return date;
	}
	
		public String getSystemDateFormate()
		{
		Date d= new Date();
		String d1 = d.toString();
		String [] date = d1.split(" ");
		
		String mon = date[1];
		String day = date[2];
		String time = date[3].replace(":", "-");
		String year = date[5];
		
		String DateFormate = day+"-"+mon+"-"+year+"-"+time;
		return DateFormate;
					
	}
}
