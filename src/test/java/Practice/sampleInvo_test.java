package Practice;

import org.testng.annotations.Test;

import com.crm.generic.library.test.JavaUtility;

public class sampleInvo_test 
{
	@Test(invocationCount = 5)
	public void deleteSampleTest()
	{
		//random number 
		JavaUtility jLib=new JavaUtility();
		String contactName ="Sample_"+jLib.getRandomNumber();
		System.out.println(contactName+" ==> Test");
	}
	
	@Test(enabled = false)
	public void CreateSampleTest()
	{
		System.out.println("this create Sample Test");
	}
	
}
