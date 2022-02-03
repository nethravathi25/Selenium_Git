package com.crm.modules.Test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.ObjectRepositoryLib.ContactInformation;
import com.crm.ObjectRepositoryLib.Contacts;
import com.crm.ObjectRepositoryLib.CreateNewContacts;
import com.crm.ObjectRepositoryLib.CreateNewOrganization;
import com.crm.ObjectRepositoryLib.Home;
import com.crm.ObjectRepositoryLib.Login;
import com.crm.ObjectRepositoryLib.OrganizationInfo;
import com.crm.ObjectRepositoryLib.Organizations;
import com.crm.generic.library.test.BaseAnnotationClass;
import com.crm.generic.library.test.ExcelUtility;
import com.crm.generic.library.test.FileUtility;
import com.crm.generic.library.test.JavaUtility;
import com.crm.generic.library.test.WebDriverUtility;

public class OrgModules_Test extends BaseAnnotationClass
{
	@Test(groups = "smokeTest")
	public void OrgTest() throws Throwable
	{
		String orgName = eLib.getDataFromExcel("Sheet2", 1, 2)+jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("Sheet2", 1, 3);
		
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.xpath("(//input[@class='detailedViewTextBox'])[1]")).sendKeys(orgName);
		WebElement dd=driver.findElement(By.name("industry"));
		String option="Education";
		wLib.select(dd, option);
		WebElement in=driver.findElement(By.name("accounttype"));
		wLib.select(in, 2);
		driver.findElement(By.name("accounttype"));
		wLib.select(in, 2);
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
		
		String actualText = driver.findElement(By.className("dvHeaderText")).getText();
		if(actualText.contains(orgName))
		{
			System.out.println("Organization is created successfully and passed");
		}
		else
		{
			System.out.println("Organization is not created successfully and failed");
		}
		
		driver.findElement(By.linkText("Organizations")).click();
		System.out.println("1sr pass");
		
		
	}
	
	@Test(groups = "regressionTest")
	public void OrgWithInd() throws Throwable
	{
	/*	String orgName = eLib.getDataFromExcel("Sheet2", 1, 2)+jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("Sheet2", 1, 3);
	
		
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
		}*/
		
		
		
		driver.findElement(By.linkText("Organizations")).click();
		System.out.println("2nd pass");
		
	}
	

}
