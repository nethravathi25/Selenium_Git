package com.crm.comcast.orgtest;

import javax.security.auth.login.LoginContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.crm.ObjectRepositoryLib.CreateNewOrganization;
import com.crm.ObjectRepositoryLib.Home;
import com.crm.ObjectRepositoryLib.Login;
import com.crm.ObjectRepositoryLib.OrganizationInfo;
import com.crm.ObjectRepositoryLib.Organizations;
import com.crm.generic.library.test.ExcelUtility;
import com.crm.generic.library.test.FileUtility;
import com.crm.generic.library.test.JavaUtility;
import com.crm.generic.library.test.WebDriverUtility;

public class CreateOrgWithIndustryTest 
{
	public static void main(String[] args) throws Throwable 
	{
		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String Browser = fLib.getPropertyKeyValue("browser");
		String Url = fLib.getPropertyKeyValue("url");
		String UserName = fLib.getPropertyKeyValue("username");
		String password = fLib.getPropertyKeyValue("password");
		
		String orgName = eLib.getDataFromExcel("Sheet2", 1, 2)+jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("Sheet2", 1, 3);
		
		WebDriver driver=null;
		if(Browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else
		{
			System.out.println("Invalid Browser please try with valid browser");
		}
		
		driver.get(Url);
		wLib.waitUntilPageLoad(driver);
		
		Login lg=new Login(driver);
		lg.loginToApp(UserName, password);
		
		Home hp=new Home(driver);
		hp.getOrganizationLink().click();
		
		Organizations org=new Organizations(driver);
		org.getCreateOrgImg().click();
		
		CreateNewOrganization cnorg=new CreateNewOrganization(driver);
		cnorg.createOrg(orgName);
		
		OrganizationInfo orginfo=new OrganizationInfo(driver);
		String actOrgMsg = orginfo.getSuccessfulMsg().getText();
		if(actOrgMsg.trim().contains(orgName))
		{
			System.out.println("org created successfully---------PASS");
		}
		else
		{
			System.out.println("org not created successfully---------FAIL");
		}
		
		String actualOrgInfo = orginfo.getIndustrySuccessMsg().getText();
		if(actualOrgInfo.equals(industry))
		{
			System.out.println("org is successfully created with industry-----PASS");
		}
		else
		{
			System.out.println("org is not created with industry--------FAIL");
		}
		hp.logout();
		driver.quit();
		
	}
	
}

