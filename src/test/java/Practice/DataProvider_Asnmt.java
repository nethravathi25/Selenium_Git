package Practice;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_Asnmt 
{
	@Test(dataProvider = "dp_Org_Inds")
	public void OrgData(String un, String pwd)
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
		
		//driver.close();
	}

	@DataProvider
	public Object[][] dp_Org_Inds()
	{
		Object[][] objDp = new Object[1][2];
	
		objDp[0][0]="admin";
		objDp[0][1]="admin";
		
		/*
		objDp[1][0]="admin";
		objDp[1][1]="admin";
		
		objDp[2][0]="admin";
		objDp[2][1]="admin";
		
		objDp[3][0]="admin";
		objDp[3][1]="admin";	*/
		
		return objDp;
		
	}
}
