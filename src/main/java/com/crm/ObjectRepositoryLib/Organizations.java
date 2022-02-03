package com.crm.ObjectRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations 
{
	public Organizations(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindAll({@FindBy(xpath = "//img[@alt='Create Organization...']"),@FindBy(xpath = "//img[@title='Create Organization...']")})
	private WebElement createOrgImg;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search")
	private WebElement searchBtn;

	
	public WebElement getCreateOrgImg() 
	{
		return createOrgImg;
	}

	public WebElement getSearchEdt() 
	{
		return searchEdt;
	}

	public WebElement getSearchBtn() 
	{
		return searchBtn;
	}
	
}
