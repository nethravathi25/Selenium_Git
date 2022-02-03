package com.crm.ObjectRepositoryLib;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.generic.library.test.WebDriverUtility;

public class CreateNewContacts extends WebDriverUtility
{
	WebDriver driver=null;
	
	public CreateNewContacts(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement contactsEdt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement selectBtn;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	public void CreateContact(String lastName)
	{
		contactsEdt.sendKeys(lastName);
		saveBtn.click();
	}
	
	public void CreateContact(String lastName,String OrgName) throws Throwable
	{
		contactsEdt.sendKeys(lastName);
		selectBtn.click();
		switchToWindow(driver, "Accounts&action");
		
		Organizations org=new Organizations(driver);
		org.getSearchEdt().sendKeys(OrgName);
		org.getSearchBtn().click();
		org.getCreateOrgImg().click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[Contains(text()='\"+orgName+\"')]")).click();
		switchToWindow(driver, "contacts&action");
		saveBtn.click();
	}
}
