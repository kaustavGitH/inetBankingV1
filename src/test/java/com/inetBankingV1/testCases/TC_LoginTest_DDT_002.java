package com.inetBankingV1.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.inetBankingV1.pageObjects.HomePage;
import com.inetBankingV1.pageObjects.LoginPage;
import com.inetBankingV1.utilities.ReportGenerator;
import com.inetBankingV1.utilities.XLSUtils;

@Listeners(ReportGenerator.class)
public class TC_LoginTest_DDT_002 extends BaseClass{
	
	@Test(dataProvider="getData")
	public void LoginTestDDT(String uname,String pword)
	{
		HomePage hp=new HomePage(driver);
		LoginPage lp=new LoginPage(driver);
		log.info("Entered Username");
		lp.setUserName(uname);
		log.info("Entered Password");
		lp.setPassWord(pword);
		lp.clickOnSubmit();
		if(checkAlertisPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			log.warn("Login failed");
		}
		else
		{
			hp.clickOnLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			log.warn("Login passed");
		}
		
	}
	
	public boolean checkAlertisPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetBankingV1/testData/LoginCredentials.xlsx";
		int rownum=XLSUtils.getRowCount(path, "Sheet1");
		int colnum=XLSUtils.getCellCount(path, "Sheet1", 1);
		
		Object data[][]=new Object[rownum][colnum];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colnum;j++)
			{
				data[i-1][j]=XLSUtils.getCellData(path,"Sheet1",i,j);
			}
		}
		return data;
		
	}

}
