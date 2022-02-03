package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.generic.library.test.ExcelUtility;

public class SampleXlsxFileReader_test 
{
	@Test(dataProvider = "dp_AddToCart")
	public void AddToCartAndBill(String pName, String pNum)
	{
		System.out.println("Execute "+pName+" "+pNum+" Add to the care and bill");
	}
	@DataProvider
	public Object[][] dp_AddToCart() throws Throwable
	{
		ExcelUtility eLib=new ExcelUtility();
		int rowcount=eLib.getRowCount("addToCart");
		
		Object[][] objarr=new Object[rowcount][2];
		
		for(int i=0;i<rowcount;i++)
		{
		objarr[i][0]=eLib.getDataFromExcel("addToCart",i,0);
		
		objarr[i][1]=eLib.getDataFromExcel("addToCart",i,1);
		}
		
		return objarr;
	}

}


