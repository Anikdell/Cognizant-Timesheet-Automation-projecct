package com.project.login;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.project.calender.Submit;
import com.project.generic.ExtentReport;
import com.project.generic.Highlight;
import com.project.generic.Screenshot;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@SuppressWarnings("unused")
public class Login {
	static ExtentTest test;
    static ExtentReports extent=ExtentReport.generateExtent() ;
    static String loginID=null;
    static String passwordID=null;
    static String result = null; 
    public static String loadProperties(String request) {
        try {
            Properties properties = new Properties();
            FileInputStream file = new FileInputStream("C:\\Users\\DELL\\OneDrive\\Desktop\\Main project\\timesheet\\src\\main\\java\\config.properties");
            properties.load(file);
            if(request.equals("loginid")) {
            	result = properties.getProperty("loginID");
            }else{
            	result = properties.getProperty("passwordID");
            }
      
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
	public static void login(WebDriver driver) throws InterruptedException, IOException {
		        

				String yesLocator = "//input[@value='Yes']";
				String name = "mectrl_currentAccount_primary";              //located by id
		        String mailid = "mectrl_currentAccount_secondary";          //located by id
		        
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				 test = extent.createTest(" Homepage");
			     test.info("Test Started");
				//locating and entering the login credentials in the sign in field
				WebElement signinId = driver.findElement(By.xpath("//input[@maxlength='113']"));
				Screenshot.takeScreenshot(driver, "Username");
				Highlight.highlightElement(driver, signinId);
				loginID=loadProperties("loginid");
				signinId.sendKeys(loginID, Keys.ENTER);
				
				// Wait for next page to settle
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				test = extent.createTest(" Selected date");
		        test.info("Test Started");
				//locating and entering the password credentials in the enter password field
				WebElement passwordfield = driver.findElement(By.xpath("//input[@name='passwd']"));
				Screenshot.takeScreenshot(driver, "Password");
				Highlight.highlightElement(driver, passwordfield);
				passwordID=loadProperties("password");
				passwordfield.sendKeys(passwordID, Keys.ENTER);
				
				//wait until authentication via mobile authenticator
				Thread.sleep(5000);
				
				//wait until visiblity of WebElement is loaded 
				driver.findElement(By.xpath("//a[normalize-space()='Not now']")).click();
				WebDriverWait wait_auth = new WebDriverWait(driver,Duration.ofSeconds(40));
				wait_auth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(yesLocator))).click();
				
				
				test = extent.createTest(" Verified User");
		        test.info("Test Started");
				//verifying the user logged in and waiting until it is observable
                String verify_user = "//*[@id='O365_MainLink_Me']";
		        WebDriverWait wait_mainpage = new WebDriverWait(driver,Duration.ofSeconds(15));
		        Screenshot.takeScreenshot(driver, "BeCognizant");
		       

		        wait_mainpage.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(verify_user))).click();
		        //wait until information is observable

		        try {
		            Thread.sleep(7000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
	     
		        // Getting the User Account details in console
		        System.out.println("*****User Account Details*****");
		        WebElement primaryElement = driver.findElement(By.id(name));
		        String loggedinName = primaryElement.getText();
		        System.out.println("        ");
		        System.out.println("Logged In Account User's Name is: " + loggedinName);
		        WebElement secondaryElement = driver.findElement(By.id(mailid));
		        String emailId = secondaryElement.getText();
		        System.out.println("Logged In Account User's Mail ID is: " + emailId);

		        System.out.println("        ");
		        System.out.println("---------********************-------------");
		        System.out.println("        ");

		        
		        Screenshot.takeScreenshot(driver, "OneCognizant");
		        //verifying the logged in user
		        String expectedName = "Mitra, Anik (Contractor)";
		        String expectedMailid = "2270757@cognizant.com";
		        if (loggedinName.equals(expectedName) && expectedMailid.equals(expectedMailid))   {
		            System.out.println("The logged in user is verified!");
		        } else {
		            System.out.println("The logged in user verification failed!");
		        }

		        System.out.println("        ");
		        System.out.println("---------********************-------------");
		        System.out.println("        ");
		        WebElement oneCognizant  = driver.findElement(By.xpath("//div[@title='OneCognizant']"));
		        oneCognizant.click();
		        Highlight.highlightElement(driver, oneCognizant);

		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		     // Get handles of all open windows
		        String parentWindow = driver.getWindowHandle();
		       
		        Set<String> windowHandles = driver.getWindowHandles();

		        // Switch to the new window
		        for (String windowHandle : windowHandles) {
		            driver.switchTo().window(windowHandle);
		        }
		        String childWindow = driver.getWindowHandle();
		      
		        WebElement submitTimesheet = driver.findElement(By.xpath("//body/div[2]/div[5]/div[2]/div/div[2]/div[1]/div[1]/div[2]/div/div/div[1]/div[1]"));
		        submitTimesheet.click();
                Thread.sleep(3000);
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Adjust the timeout as needed

		        // Wait until there are at least three window handles available
		        wait.until(ExpectedConditions.numberOfWindowsToBe(3));

		        // Get handles of all open windows
		        Set<String> windowHandlesA = driver.getWindowHandles();

		        // Switch to the third window (last window handle in the set)
		        String thirdWindowHandle = (String) windowHandlesA.toArray()[windowHandlesA.size() - 1];
		        driver.switchTo().window(thirdWindowHandle); 
		     // Switch to the third window
		      //driver.switchTo().window(thirdWindowHandle);
		        Thread.sleep(3000);
		        WebElement timesheet = driver.findElement(By.xpath("//form/div[3]/div[4]/div[2]/div/div/div/div[2]/div[3]/section/div/div[2]/div/div[1]/div[2]/div/div[2]/div/div/div/div[1]"));
		        Highlight.highlightElement(driver, signinId);
		        timesheet.click();
		        Screenshot.takeScreenshot(driver, "TimeSheet");
		        Submit.compareCalendar(driver,extent);
		       
		        extent.flush();
	}

}
