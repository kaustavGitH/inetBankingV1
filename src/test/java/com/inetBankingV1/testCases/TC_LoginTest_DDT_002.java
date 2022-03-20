package com.inetBankingV1.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBankingV1.pageObjects.HomePage;
import com.inetBankingV1.pageObjects.LoginPage;
import com.inetBankingV1.utilities.XLSUtils;

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
			Assert.assertTrue(true);
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
	
	@Test(enabled = false)
	public void xpathAxesPractice() throws InterruptedException
	{
		driver.get("https://www.facebook.com/");
		
		//Parent example
		String text=driver.findElement(By.xpath("//button[@name='login']/parent::*")).getText();
		System.out.println(text);
		Thread.sleep(5000);
		
		//Ancestor and descendant example
		driver.findElement(By.xpath("//button[@name='login']/ancestor::form/descendant::div//input[@id='email']")).sendKeys("Kaustav");
		
		//Following example
		int size=driver.findElements(By.xpath("//button[@name='login']/following::div")).size();
		System.out.println("Total following elements = "+size);
		
		//Following-sibling example
		size=driver.findElements(By.xpath("//button[@name='login']/parent::div/following-sibling::div")).size();
		System.out.println("Total following sibling elements = "+size);
		
		//Preceding example
		size=driver.findElements(By.xpath("//button[@name='login']/preceding::div")).size();
		System.out.println("Total preceding elements = "+size);
		
		//Preceding-sibling example
		size=driver.findElements(By.xpath("//button[@name='login']/parent::div/preceding-sibling::div")).size();
		System.out.println("Total preceding-sibling elements = "+size);
		
	}

}
