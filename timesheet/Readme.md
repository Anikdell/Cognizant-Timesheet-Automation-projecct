### Cognizant Timesheet


## Team Members

	1. Anik Mitra           (2270757)
	2. Viraj Dalvi          (2282042)
	3. Vasanthan Selvakumar (2282160)
	4. Ishwar Hase          (2282336)
	5. Dileep Pasvan        (2270754)

Problem Statement : To Verify TimeSheet
1.Login into Be.cognizant(For edge browser login not required)
2.Verify the user name
3.Scroll down and click on onecognizant
4.Click on submit timesheet
5.Verify timesheet date with system calendar date.
6.Verify searchby Date and Status of Timesheet.
 	
	

## Project Description

*description*

The project will be implemented using a web automation framework, such as Selenium, and will follow the steps outlined below:

### Objectives


## 1.Login

	1. Open the be.cognizant.com website.
	2. Enter the login credentials to authenticate the user.


## 2.Retrieve User Details:

	1. Once authenticated, navigate to the home page.
	2. Click on the user profile, which will open in a new tab.
	3. Print the user details obtained from the profile page.
	4. Navigate back to the home page.


## 3.Redirect to One Cognizant:
       
       1.Click on One Cognizant in BeCognizant page.


## 4.Redirect to TimeSheet:

       1.Click on submit timesheet.
       2.Fetch the date of first three week.
       3.Verify the retrieved date with system calendar.
       

## 5.Click on Date and Status to filter different dropdown option:
       
       1.Click on approved.
       2.Click on pending.
       3.Click on submitted for approval.

The project will provide an automated solution to perform these tasks efficiently, saving time and effort for the user. It aims to streamline the process of *insert tasks* on the Cognizant website.

### The project is organized into *n* packages:

*Pages*: Contains the following classes:
   		  1. Submit
                2. TimeSheetDate
                3. LoginStatus
                4. BrowserDriver
                5. Main
                6. ExtentReport
                7. Highlight
                8. Screenshot
                9. Login
    	       


### How to Run the Project

	1. Import the project into Eclipse IDE. It will automatically open the Package Explorer.
	2. Download the appropriate drivers for your web browser version from the internet.
	3. After downloading the drivers, extract them and copy them. Go back to Eclipse IDE, right-click on the project folder, and paste the drivers.
	4. Expand src/main/java, then expand the Utilities package, and open DriverSetup.java.
	5. In the DriverSetup class, go to the Webdriver class and provide the path to the drivers according to your configuration. You can get the path of 	   the drivers by right-clicking on the project folder, selecting Properties, and navigating to the location where you pasted the drivers.
	6. Open the application.properties file and specify the browser you want to use for automation by removing "chrome" from the second line.
	7. Change the Excel sheet location to src/main/resources.
	8. You can now run the program by opening src/test/java, expanding the Test package, and opening AllTest.java. You can run the tests by clicking  	   "Run All" or run them as a TestSuite using an XML file.

### Key Automation Scope

	The automation script aims to achieve the following key objectives:

         Handling different browser windows
         Handling dropdown option
         Handling  to home page
         Extract multiple date & store in list
         Data Driven approach
         Cross Browser

###Technology & Tools Used:

        -Selenium WebDriver
        -Java
        -Maven
        -POM
        -Java
        -HTML Extent Report
        -Property File
 

By automating these tasks, the script provides an efficient solution for users to retrieve information from the Cognizant website, saving time and effort.

*******************************************************FILES DESCRIPTION**************************************************************

1.src/main/java - There are three packages present in this folder.
     ->Property:In this package we have config.properties. In this File we have to give from user to use which browser 
     chrome/microsoftedge etc. 
     ->Base:In this package we have Base.java is our main project file in which we Firstly invoke the selected browser and 
          Open the Be.cognizant page (https://be.cognizant.com/),reusable method for list & count and closing the browser
     ->Pages:In this package we have 1 Class Trutime.java which extends base.java where the methods are present which will login 
     to the page by scanning the otp in the console and then print all the dates of the present week in the console.
     ->Utils:In this package we have class ExtentReportManager which is used for extent reports and class ReadWrite which is used 
     to write data in excel sheet.
2.JRE System Library: In this File we have all dependencies of JAR.files.         
3.Maven Dependencies: In this File we have all the directory on the local machine, where all the project artifacts are stored. 
  when a Maven build is executed, Maven automatically downloads all the dependency jars into the local repository. Usually, this directory is named.   
4.Drivers- In this folder, the chorme driver,microsoftedge and gecko driver are present
5.ScreenShot:There are images of different test cases.
6.pom.xml: The pom.xml file contains information of project and configuration information for the maven to build the project 
  such as dependencies, build directory, source directory, test source directory, plugin, goals etc. Maven reads the pom.xml file, then executes 
  the goal.
 
***************************************************************************************************************************************
