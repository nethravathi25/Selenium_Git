package com.crm.comcast.contacttest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import com.crm.ObjectRepositoryLib.ContactInformation;
import com.crm.ObjectRepositoryLib.Contacts;
import com.crm.ObjectRepositoryLib.CreateNewContacts;
import com.crm.ObjectRepositoryLib.Home;
import com.crm.ObjectRepositoryLib.Login;
import com.crm.generic.library.test.ExcelUtility;
import com.crm.generic.library.test.FileUtility;
import com.crm.generic.library.test.JavaUtility;
import com.crm.generic.library.test.WebDriverUtility;

public class ContactTNGTest 
{
	@Test
	public void ContactTNGTest() throws Throwable
	{
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		
		String lastName = eLib.getDataFromExcel("Sheet2", 1, 3)+jLib.getRandomNumber();
		
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else
		{
			System.out.println("Invalid Browser");
		}
		driver.get(URL);
		wLib.waitUntilPageLoad(driver);
		
		Login lg=new Login(driver);
		lg.loginToApp(USERNAME, PASSWORD);
		
		Home hp=new Home(driver);
		hp.getContactsLink().click();
		
		Contacts cp=new Contacts(driver);
		cp.getContactBtn().click();
		
		CreateNewContacts cnc=new CreateNewContacts(driver);
		cnc.CreateContact(lastName);
		
		ContactInformation cinfo=new ContactInformation(driver);
		String actName = cinfo.getSuccessfulMsg().getText();
		
		if(actName.contains(lastName))
		{
			System.out.println(lastName+"------lastName is verified---------PASSES");
		}
		else
		{
			System.out.println(lastName+"-------------lastName is not verified------------FAILED");
		}
		hp.logout();
		driver.quit();
	}
}


