package com.inetBankingV1.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports getReport()
	{
		String date=new SimpleDateFormat("MM_dd_yyyy__hh_mm_ss").format(new Date());
		String path=System.getProperty("user.dir")+"\\reports\\index"+date+".html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("inetBankingV1_Automation");
		reporter.config().setTheme(Theme.DARK);
		
		
		ExtentReports report=new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Tester name:", "Kaustav");
		return report;
	}

}
