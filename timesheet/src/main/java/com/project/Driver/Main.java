package com.project.Driver;

import java.util.Scanner;

import com.project.date.LoginStatus;
import com.project.login.Login;
import com.project.calender.Submit;
import com.project.calender.TimeSheetDate;

public class Main {

	  public static void main(String[] args) throws Exception {
	        // create BrowerDriver instance
	        BrowserDriver bd = new BrowserDriver();
	        System.out.println("Choose the Browser");
	        System.out.println("1.Chrome");
	        System.out.println("2.Edge");
	        //create scanner instance
	        Scanner sc = new Scanner(System.in);
	        //get user input
	        int choice = sc.nextInt();

	        //verify the choice
	        if(choice == 1) {
	           bd.initializeDriver("chrome");
	        }else {
	        	bd.initializeDriver("edge");
	        } 

	    }
}
