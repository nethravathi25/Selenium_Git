package com.crm.ObjectRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login 
{
	public Login(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement userPassEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	public WebElement getUserNameEdt()
	{
		return userNameEdt;
	}

	public WebElement getUserPassEdt() 
	{
		return userPassEdt;
	}

	public WebElement getLoginBtn() 
	{
		return loginBtn;
	}
	
	public void loginToApp(String username, String password)
	{
		userNameEdt.sendKeys(username);
		userPassEdt.sendKeys(password);
		loginBtn.click();
	}

}
