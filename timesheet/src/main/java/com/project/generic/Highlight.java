package com.project.generic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Highlight{
	 public static void highlightElement(WebDriver driver, WebElement element) {
	        try {
	            JavascriptExecutor js = (JavascriptExecutor) driver;

	            // Store the original element style
	            String originalStyle = element.getAttribute("style");

	            // Add a red border around the element
	            js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 5px solid red;');", element);

	            // Wait for a short duration
	            Thread.sleep(500);

	            // Restore the original element style
	            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, originalStyle);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}