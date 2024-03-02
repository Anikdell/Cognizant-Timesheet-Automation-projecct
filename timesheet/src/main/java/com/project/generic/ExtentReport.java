package com.project.generic;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	public static ExtentReports generateExtent() {
		// TODO Auto-generated method stub
		ExtentReports extent;
		 extent = new ExtentReports();
		  ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Users\\DELL\\OneDrive\\Desktop\\Main project\\timesheet\\extentreport\\extentreport.html");
		  extent.attachReporter(htmlReporter);
		  return extent;
		  
	}

}
