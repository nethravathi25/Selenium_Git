package com.crm.ObjectRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfo 
{
	public OrganizationInfo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//td[@class='dvtSelectedCell']")
	private WebElement successfulMsg;
	
	@FindBy(xpath = "(//td[@class='dvtCellLabel'])[13]")
	private WebElement industrySuccessMsg;

	public WebElement getSuccessfulMsg() 
	{
		return successfulMsg;
	}

	public WebElement getIndustrySuccessMsg() 
	{
		return industrySuccessMsg;
	}
	
	

}
