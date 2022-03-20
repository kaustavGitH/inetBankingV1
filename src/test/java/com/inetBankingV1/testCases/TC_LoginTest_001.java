package com.inetBankingV1.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetBankingV1.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void LoginTest()
	{
		log.info("Navigating to URL");
		driver.get(baseURL);
		log.info("Opened the URL");
		LoginPage lp=new LoginPage(driver);
		log.info("Provide username and password");
		lp.setUserName(username);
		log.info("Entered username");
		lp.setPassWord(password);
		log.info("Entered password");
		lp.clickOnSubmit();
		log.info("Clicked on submit");
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			log.info("Title matched");
			Assert.assertTrue(true);
		}
		else
		{
			log.info("Title not matched");
			Assert.assertTrue(false);
		}
	}
}
