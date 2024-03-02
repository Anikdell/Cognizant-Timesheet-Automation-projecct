package com.project.calender;

import java.time.Month;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.project.calender.DateVerification;
import com.project.calender.TimeSheetDate;
import com.project.date.LoginStatus;

public class Submit {

	public static void compareCalendar(WebDriver driver,ExtentReports extent) throws InterruptedException {
		ExtentTest test;
	    
		
	    test = extent.createTest(" Verified Timesheet Date with System calendar");
        test.info("Test Started");
        int dayInTimeSheet = 0;
        String monthInTimeSheet = null;
        int yearInTimeSheet = 0;
        int monthNumber = 0;
      //  String date = null;
        String firstWeekInTimeSheet = null;
        String secondWeekInTimeSheet = null;

        String thirdWeekInTimeSheet = null;
       for(int i = 1;i < 4;i++) {
           if(i==1) {
        	   firstWeekInTimeSheet = driver.findElement(By.xpath("//body/form/div[3]/div[4]/div[2]/div/div/div/div/div[2]/div/div["+i+"]/div/div/div/span/a[1]")).getText();
           }else if(i==2){
        	   secondWeekInTimeSheet = driver.findElement(By.xpath("//body/form/div[3]/div[4]/div[2]/div/div/div/div/div[2]/div/div["+i+"]/div/div/div/span/a[1]")).getText();
                // System.out.println(date);
           }else {
               thirdWeekInTimeSheet = driver.findElement(By.xpath("//body/form/div[3]/div[4]/div[2]/div/div/div/div/div[2]/div/div["+i+"]/div/div/div/span/a[1]")).getText();
           }
       }
       
	
		TimeSheetDate tsd = new TimeSheetDate(1,dayInTimeSheet,monthNumber,yearInTimeSheet);
        tsd.firstDateOfWeek();
		tsd.dateVerification(firstWeekInTimeSheet,secondWeekInTimeSheet,thirdWeekInTimeSheet);   
		LoginStatus.checkStatus(driver,extent);
		test.pass("Test Passed");
		extent.flush();
  }
}
