package com.inetBankingV1.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBankingV1.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig rc=new ReadConfig();
	String username=rc.getUserName();
	String password=rc.getPassword();
	String baseURL=rc.getBaseURL();
	static WebDriver driver;
	Logger log;
	
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br)
	{
		log=Logger.getLogger("eBanking");
		PropertyConfigurator.configure("Log4j.properties");
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",rc.getChromePath());
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",rc.getFirefoxPath());
			driver=new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void takeScreenshot(String testCaseName) throws IOException
	{
		String date=new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String des=System.getProperty("user.dir")+"\\Screenshots\\"+testCaseName+"-"+date+".png";
		FileUtils.copyFile(src,new File(des));
	}

}
