package com.inetBankingV1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="uid")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement passWord;
	
	@FindBy(name="btnLogin")
	WebElement loginButton;
	
	@FindBy(name="btnReset")
	WebElement resetButton;
	
	public void setUserName(String username)
	{
		userName.sendKeys(username);
	}
	public void setPassWord(String password)
	{
		passWord.sendKeys(password);
	}
	public void clickOnSubmit()
	{
		loginButton.click();
	}
	public void clickOnReset()
	{
		resetButton.click();
	}

}
