package Practice;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.ObjectRepositoryLib.CreateNewOrganization;
import com.crm.ObjectRepositoryLib.Home;
import com.crm.ObjectRepositoryLib.OrganizationInfo;
import com.crm.ObjectRepositoryLib.Organizations;
import com.crm.generic.library.test.BaseAnnotationClass;
import com.crm.generic.library.test.ExcelUtility;
import com.mysql.cj.jdbc.Driver;

public class OrgWithDataProviderTest extends BaseAnnotationClass
{
	@Test
	public void orgVithDataProvider(String orgName, String indType)
	{
		Home hp=new Home(driver);
		hp.getOrganizationLink().click();
		
		Organizations org=new Organizations(driver);
		org.getCreateOrgImg().click();
		
		CreateNewOrganization corg=new CreateNewOrganization(driver);
		corg.createOrg(orgName);
		
		OrganizationInfo orginf=new OrganizationInfo(driver);
		String actiOrgMsg = orginf.getSuccessfulMsg().getText();
		
		Assert.assertTrue(actiOrgMsg.contains(orgName));
		String actualInfo = orginf.getIndustrySuccessMsg().getText();
	}
	
	@DataProvider
	public Object[][] dataProvider_industryType() throws Throwable
	{
		ExcelUtility eLib=new ExcelUtility();
		int rowCount=eLib.getRowCount("industryType");
		
		Object[][] objAry=new Object[rowCount][2];
		
		for(int i=0;i<rowCount;i++)
		{
			objAry[i][0]=eLib.getDataFromExcel("industryType", i, 0)+jLib.getRandomNumber();
			objAry[i][0]=eLib.getDataFromExcel("industryType", i, 1);
		}
		
		return objAry;
		
	}

}
