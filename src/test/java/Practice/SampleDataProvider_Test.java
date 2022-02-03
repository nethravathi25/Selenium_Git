package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleDataProvider_Test
{
	@Test(dataProvider = "dp_AddToCart")
	public void AddToCartAndBill(String pName, int pNum)
	{
		System.out.println("Execute "+pName+" "+pNum+" Add to the care and bill");
	}
	@DataProvider
	public Object[][] dp_AddToCart()
	{
		Object[][] objarr=new Object[5][2];
		
		objarr[0][0]="Nokia";
		objarr[0][1]=10;
		objarr[1][0]="Samsung";
		objarr[1][1]=20;
		objarr[2][0]="Vivo";
		objarr[2][1]=30;
		objarr[3][0]="Apple";
		objarr[3][1]=40;
		objarr[4][0]="One+";
		objarr[4][1]=50;
		
		return objarr;
	}

}
