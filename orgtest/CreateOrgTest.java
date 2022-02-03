package com.crm.comcast.orgtest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.generic.library.test.ExcelUtility;
import com.crm.generic.library.test.FileUtility;
import com.crm.generic.library.test.JavaUtility;
import com.crm.generic.library.test.WebDriverUtility;

public class CreateOrgTest 
{
	public static void main(String[] args) throws Throwable 
	{
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		
		int randomInt =jLib.getRandomNumber();
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String URL = fLib.getPropertyKeyValue("url");
		String BROWSER = fLib.getPropertyKeyValue("browser");
		
		String orgName = eLib.getDataFromExcel("Sheet1", 1, 0) + randomInt;
		WebDriver driver=null;
		
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
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Organizations")).click();
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
		
		WebElement sw = driver.findElement(By.linkText("Contacts"));
		sw.click();
		//String act = sw.getText();
		//wLib.switchToWindow(driver, act);
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		driver.findElement(By.name("account_name")).sendKeys(orgName);
		driver.findElement(By.xpath("(//img[@language='javascript'])[1]")).click();
		
		
		WebElement move=driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[2]"));
		wLib.mouseover(driver, move);
		
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("logout successfully and display login page");
		driver.quit();
		
	}


}
