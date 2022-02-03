package com.crm.modules.Test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.generic.library.test.BaseAnnotationClass;

public class ContactModule_Test extends BaseAnnotationClass
{

	@Test(groups = "smokeTest")
	public void OrgTest() throws Throwable
	{
		/*String orgName = eLib.getDataFromExcel("Sheet2", 1, 2)+jLib.getRandomNumber();
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
		}*/
		
		driver.findElement(By.linkText("Organizations")).click();
		System.out.println("1sr pass");
		
		
	}
	
	@Test(groups = "smokeTest")
	public void OrgWithIndTest() throws Throwable
	{
		/*String orgName = eLib.getDataFromExcel("Sheet2", 1, 2)+jLib.getRandomNumber();
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
		}*/
		
		driver.findElement(By.linkText("Organizations")).click();
		System.out.println("2nd pass");
		
		
	}
}
