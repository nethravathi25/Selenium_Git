package Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class sampleBefAftmethods_Test 
{
	@BeforeClass
	public void configBC()
	{
		System.out.println("================launch browser==================");	
	}
	
	@BeforeMethod
	public void configBM()
	{
		System.out.println("step 1 : Login");
	}
	
	
	@Test
	public void CreateContactTest()
	{
		System.out.println("step 2 : Navigate to create contect");
		System.out.println("step 3 : Create a new contact");
		System.out.println("step 4 : Verify");
	}
	
	@Test
	public void ModifyContactTest()
	{
		System.out.println("step 2 : Navigate to create contect");
		System.out.println("step 3 : Create a new contact and modify");
		System.out.println("step 4 : Verify");
	}
	
	@AfterMethod
	public void configAC()
	{
		System.out.println("step 5 : Logout");
	}
	
	@AfterClass
	public void configAM()
	{
		System.out.println("==============Close the browser==================");
	}

}
