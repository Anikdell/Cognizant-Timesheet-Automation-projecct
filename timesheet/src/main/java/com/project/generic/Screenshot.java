package com.project.generic;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Screenshot{

    public static void takeScreenshot(WebDriver driver, String screenshotName) {
        try {
            // Convert WebDriver object to TakesScreenshot
            TakesScreenshot ts = (TakesScreenshot) driver;

            // Capture screenshot as File
            File source = ts.getScreenshotAs(OutputType.FILE);

            // Define the destination path and filename for the screenshot
            String destDir = "C:\\Users\\DELL\\OneDrive\\Desktop\\Main project\\timesheet\\Screenshot";
            File dest = new File(destDir, screenshotName + ".png");

            // Copy the screenshot from the source to the destination
            FileUtils.copyFile(source, dest);

            System.out.println("Screenshot taken and saved at: " + dest.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


