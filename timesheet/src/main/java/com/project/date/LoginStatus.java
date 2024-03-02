package com.project.date;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.project.generic.Screenshot;

@SuppressWarnings("unused")
public class LoginStatus {
    
	public static void checkStatus(WebDriver driver,ExtentReports extent) throws InterruptedException {
		ExtentTest test;
	    
	    
	    
		test = extent.createTest(" Selected date");
        test.info("Test Started");
        // Select date from search by dropdown
        Select searchByDropdown = new Select(driver.findElement(By.id("CTS_TS_LAND_WRK_CTS_TS_SEARCH")));
        searchByDropdown.selectByVisibleText("Date");
        
        // Click calender icon
        driver.findElement(By.id("CTS_TS_LAND_WRK_DATE$prompt")).click();
        // Click current date
        driver.findElement(By.id("curdate")).click();
        test.pass("Test Passed");
        // Click search
        driver.findElement(By.id("CTS_TS_LAND_WRK_SEARCH")).click();
        Thread.sleep(3000); // Wait for 3 seconds
        Screenshot.takeScreenshot(driver, "Date");
        Thread.sleep(5000); // Wait for 5 seconds
        test.pass("Test Passed");
        
        test = extent.createTest(" Selected status");
        test.info("Test Started");
        // Select status from search by dropdown
        Select searchByDropdownAgain = new Select(driver.findElement(By.id("CTS_TS_LAND_WRK_CTS_TS_SEARCH")));
        searchByDropdownAgain.selectByValue("2");
        test.pass("Test Passed");
        
        test = extent.createTest(" Selected Approved option");
        test.info("Test Started");
       
        // Select Approved from status dropdown and click search
        Select statusDropdown = new Select(driver.findElement(By.xpath("//select[@id='CTS_TS_LAND_WRK_CTS_TS_LAND_STATUS']")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        statusDropdown.selectByVisibleText("Approved");
        driver.findElement(By.id("CTS_TS_LAND_WRK_SEARCH")).click();
        Thread.sleep(3000); // Wait for 3 seconds
        Screenshot.takeScreenshot(driver, "Approved");
        Thread.sleep(3000); // Wait for 3 seconds
        test.pass("Test Passed");
        
        test = extent.createTest("  Selected Overdue option");
	    test.info("Test Started");
	    
        // Select Overdue from status dropdown and click search
        statusDropdown = new Select(driver.findElement(By.xpath("//select[@id='CTS_TS_LAND_WRK_CTS_TS_LAND_STATUS']")));
        statusDropdown.selectByVisibleText("Overdue");
        driver.findElement(By.id("CTS_TS_LAND_WRK_SEARCH")).click();
        Thread.sleep(2000); // Wait for 2 seconds
        driver.findElement(By.xpath("//span[contains(text(),'OK')]")).click();
        Thread.sleep(3000); // Wait for 3 seconds
        Screenshot.takeScreenshot(driver, "Overdue");
        Thread.sleep(3000);
        
        test = extent.createTest("  Selected Partially Approved option");
        test.info("Test Started");
        // Select Partially Approved from status dropdown and click search
        statusDropdown = new Select(driver.findElement(By.xpath("//select[@id='CTS_TS_LAND_WRK_CTS_TS_LAND_STATUS']")));
        statusDropdown.selectByVisibleText("Partially Approved");
        driver.findElement(By.id("CTS_TS_LAND_WRK_SEARCH")).click();
        Thread.sleep(2000); // Wait for 2 seconds
        driver.findElement(By.xpath("//span[contains(text(),'OK')]")).click();
        Thread.sleep(3000); // Wait for 3 seconds
        Screenshot.takeScreenshot(driver, "Partially_Approved");
        Thread.sleep(3000);
        test.pass("Test Passed");
        
        test = extent.createTest("  Selected Pending option");
	    test.info("Test Started");
        // Select Pending from status dropdown and click search
        statusDropdown = new Select(driver.findElement(By.xpath("//select[@id='CTS_TS_LAND_WRK_CTS_TS_LAND_STATUS']")));
        statusDropdown.selectByVisibleText("Pending");
        driver.findElement(By.id("CTS_TS_LAND_WRK_SEARCH")).click();
        Thread.sleep(2000); // Wait for 2 seconds
        test.pass("Test Passed");
        //driver.findElement(By.xpath("//span[contains(text(),'OK')]")).click();
        Thread.sleep(3000); // Wait for 3 seconds
        Screenshot.takeScreenshot(driver, "Pending");
        Thread.sleep(3000);
        
        test = extent.createTest("  Selected Saved option");
	     test.info("Test Started");
        // Select Saved from status dropdown and click search
        statusDropdown = new Select(driver.findElement(By.xpath("//select[@id='CTS_TS_LAND_WRK_CTS_TS_LAND_STATUS']")));
        statusDropdown.selectByVisibleText("Saved");
        driver.findElement(By.id("CTS_TS_LAND_WRK_SEARCH")).click();
        Thread.sleep(2000); // Wait for 2 seconds
        driver.findElement(By.xpath("//span[contains(text(),'OK')]")).click();
        Thread.sleep(3000); // Wait for 3 seconds
        Screenshot.takeScreenshot(driver, "Saved");
        Thread.sleep(3000);
        test.pass("Test Passed");
        
         test = extent.createTest("  Selected Send Back for Revision option");
	     test.info("Test Started");
        // Select Sent Back for Revision from status dropdown and click search
        statusDropdown = new Select(driver.findElement(By.xpath("//select[@id='CTS_TS_LAND_WRK_CTS_TS_LAND_STATUS']")));
        statusDropdown.selectByVisibleText("Sent Back for Revision");
        driver.findElement(By.id("CTS_TS_LAND_WRK_SEARCH")).click();
        Thread.sleep(2000); // Wait for 2 seconds
        driver.findElement(By.xpath("//span[contains(text(),'OK')]")).click();
        Thread.sleep(3000); // Wait for 3 seconds
        Screenshot.takeScreenshot(driver, "Revision");
        Thread.sleep(3000);
        test.pass("Test Passed");
        
         test = extent.createTest("  Selected Submitted for Approved option");
	     test.info("Test Started");
        // Select Submitted for Approval from status dropdown and click search
        statusDropdown = new Select(driver.findElement(By.xpath("//select[@id='CTS_TS_LAND_WRK_CTS_TS_LAND_STATUS']")));
        statusDropdown.selectByVisibleText("Submitted for Approval");
        driver.findElement(By.id("CTS_TS_LAND_WRK_SEARCH")).click();
        Thread.sleep(3000); // Wait for 3 seconds
        Screenshot.takeScreenshot(driver, "submitted_for_approval");
        Thread.sleep(2000); // Wait for 2 seconds
        test.pass("Test Passed");

        extent.flush();
	}

}
