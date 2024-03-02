package com.project.Driver;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.project.generic.ExtentReport;
import com.project.login.Login;


public class BrowserDriver {
	
	  WebDriver driver;
	  String baseUrl = "https://be.cognizant.com";
	  
	 ExtentReports extent =  ExtentReport.generateExtent();
	  
	 Login lg = new Login(); 
	
	  @SuppressWarnings("deprecation")
	public void initializeDriver(String browser) throws Exception{
	        //Check if parameter passed as 'chrome'
	        if(browser.equalsIgnoreCase("chrome")){
	        	//set path to chromedriver.exe
	            System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\OneDrive\\Desktop\\Main project\\timesheet\\Driver\\chromedriver.exe");
	            //create chrome instance
	            WebDriver driver = new ChromeDriver();
	            driver.manage().window().maximize();
	            //Go to the website
	            driver.get(baseUrl);
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	            //Get the parent window
	            lg.login(driver);
	            driver.quit();
	           
	        }
	        //Check if parameter passed as 'edge'
	        else if(browser.equalsIgnoreCase("edge")) {
              //set path to IE.exe
              System.setProperty("webdriver.msedge.driver","C:\\Users\\DELL\\OneDrive\\Desktop\\Main project\\timesheet\\Driver\\msedgedriver.exe");
              //create edge instance
              driver = new EdgeDriver();
              driver.manage().window().maximize();
              //Go to the website
	            driver.get(baseUrl);
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	            lg.login(driver);
              //driver.quit();
   
	        }
	        else{
	            //If no browser passed throw exception
	            throw new Exception("Browser is not correct");
	        }

	        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        Thread.sleep(5000);
	    }

}