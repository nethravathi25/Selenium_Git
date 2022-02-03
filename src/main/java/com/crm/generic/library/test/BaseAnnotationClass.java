package com.crm.generic.library.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.crm.ObjectRepositoryLib.Home;
import com.crm.ObjectRepositoryLib.Login;

public class BaseAnnotationClass 
{
	public ExcelUtility eLib=new ExcelUtility();
	public FileUtility fLib=new FileUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public WebDriver driver=null;

	@BeforeSuite
	public void configBS()
	{
		System.out.println("=================connect to database----------------------");
	}
	
	
	@BeforeClass
	public void configBC() throws Throwable
	{
		String URL = fLib.getPropertyKeyValue("url");
		String BROWSER = fLib.getPropertyKeyValue("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) 
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid Browser");
		}
		
		driver.get(URL);
		wLib.waitUntilPageLoad(driver);
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@BeforeMethod
	public void configBM() throws Throwable
	{
		String UserName = fLib.getPropertyKeyValue("username");
		String password = fLib.getPropertyKeyValue("password");
		Login lg=new Login(driver);
		lg.loginToApp(UserName, password);
		
	}
	
	@AfterClass
	public void configAC()
	{
		driver.quit();
	}
	@AfterMethod
	public void configAM()
	{
		Home hp=new Home(driver);
		hp.getOrganizationLink().click();
		hp.logout();
	}
	
	@AfterSuite
	public void configAS()
	{
		System.out.println("=================close database connection----------------------");
	}
	
	/*
	@BeforeClass
	public void configBC() throws Throwable
	{
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url");
		
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if (BROWSER.equals("firefox")) 
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid browser");
		}
		driver.get(URL);
		
		wLib.waitUntilPageLoad(driver);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void configBM() throws Throwable
	{
		String username = fLib.getPropertyKeyValue("username");
		String password = fLib.getPropertyKeyValue("password");
		Login lp=new Login(driver);
		lp.loginToApp(username,password);
	}

	@AfterMethod
	public void configAM()
	{
		Home hp=new Home(driver);
		hp.logout(); 
	}
	
	@AfterClass
	public void configAC()
	{
		driver.quit();
	} 
	*/
	
	
	
}
