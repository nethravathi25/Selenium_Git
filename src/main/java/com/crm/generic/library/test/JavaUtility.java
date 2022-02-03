package com.crm.generic.library.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;

/**
 * this is generic class which contains 
 * @author Lenovo
 *
 */
public class JavaUtility 
{
	/**
	 * This is generic method to create random number
	 * @return
	 */
	public int getRandomNumber()
	{
		Random random=new Random();
		int randomNum=random.nextInt(10000);
		return randomNum;
	}
	/**
	 * this is a generic method to get current system date format
	 * @return
	 */
	public String getCurrentDate()
	{
		Date date=new Date();
		String currentdate=date.toString();
		return currentdate;
		
	}
	
	/**
	 * this is generic method for specific date format
	 * @return
	 */
	public String getFinalDateFormat()
	{
		Date date=new Date();
		String d=date.toString();
		String[] dt=d.split(" ");
		String YYYY = dt[5];
		String MM = dt[1];
		String DD = dt[2];
		String format=DD+"-"+MM+"-"+YYYY;
		return format;
	}
	
	public void PressVirtualKey() throws Throwable
	{
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

}
