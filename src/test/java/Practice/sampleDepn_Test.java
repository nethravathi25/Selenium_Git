package Practice;

import org.testng.annotations.Test;

public class sampleDepn_Test 
{
	@Test
	public void deleteSampleTest()
	{
		System.out.println("this delete Sample Test");
	}
	
	@Test(dependsOnMethods = {"deleteSampleTest","ModifySampleTest"})
	public void CreateSampleTest()
	{
		System.out.println("this Create Sample Test");
	}
	
	@Test
	public void ModifySampleTest()
	{
		System.out.println("this Modify Sample Test");
	}

}
