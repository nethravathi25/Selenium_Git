package Practice;

import org.testng.annotations.Test;

public class samplePriority_Test 
{
	@Test(priority = 1)
	public void deleteSampleTest()
	{
		System.out.println("this delete Sample Test");
	}
	
	@Test(dependsOnMethods = "ModifySampleTest")
	public void CreateSampleTest()
	{
		System.out.println("this Create Sample Test");
	}
	
	@Test(dependsOnMethods = "deleteSampleTest")
	public void ModifySampleTest()
	{
		System.out.println("this Modify Sample Test");
		//System.out.println(10/0);
	}

	
}
