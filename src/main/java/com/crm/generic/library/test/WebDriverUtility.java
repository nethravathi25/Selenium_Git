package com.crm.generic.library.test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility 
{
	public void waitUntilPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	public void waitForElementVisibility(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitAndClick(WebElement element) throws Throwable
	{
		int count=0;
		while(count<20)
		{
			try
			{
				element.click();
				break;
			}
			catch(Throwable e)
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}
	
	public void select(WebElement element,String option)
	{
		Select s=new Select(element);
		s.selectByVisibleText(option);
	}
	
	public void select(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	public void mouseover(WebDriver driver, WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	
	public void switchToWindow(WebDriver driver,String partialWinTitle)
	{
		Set<String> wh = driver.getWindowHandles();
		Iterator<String> it = wh.iterator();
		while(it.hasNext())
		{
			String winId = it.next();
			 String title = driver.switchTo().window(winId).getTitle();
			if(title.contains(partialWinTitle))
			{
				break;
			}
		}
	}
	
	public void acceptAllert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void cancelAlert(WebDriver driver) 
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void scrollToWebElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
	public void switchFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchFrame(WebDriver driver, String idOrName)
	{
		driver.switchTo().frame(idOrName);
	}
	
	public void takeScreenshot(WebDriver driver, String screenshotName) throws Throwable
	{
		TakesScreenshot t=(TakesScreenshot)driver;
		File src=t.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+screenshotName+".PNG");
		FileUtils.copyFile(src, dest);
	}
	
	public void passEnterKey(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
}

















