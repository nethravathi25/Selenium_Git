package com.crm.ObjectRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformation 
{
	public ContactInformation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement successfulMsg;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement orgNameIcon;

	public WebElement getSuccessfulMsg() 
	{
		return successfulMsg;
	}

	public WebElement getOrgNameIcon()
	{
		return orgNameIcon;
	}
	
	
}
