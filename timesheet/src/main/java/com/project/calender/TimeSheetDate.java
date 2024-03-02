package com.project.calender;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SuppressWarnings("unused")
public class TimeSheetDate {
	//create list to store the date
	public static List<String> dateArray = new ArrayList();
	public int noOfWeek;
	public int dayInTimeSheet;
	public int monthNumber;
	public int yearInTimeSheet;
	public int initialDate;
	//create constructor and initialize
	public TimeSheetDate(int noOfWeek,int dayInTimeSheet, int  monthNumber, int yearInTimeSheet){

        this.noOfWeek=noOfWeek;
        this.dayInTimeSheet=dayInTimeSheet;
        this.monthNumber=monthNumber;
        this.dayInTimeSheet=dayInTimeSheet;

}
	LocalDate dateToday = LocalDate.now();
    LocalDate previousDate = LocalDate.of(2023, 8,26);
    long gap = ChronoUnit.DAYS.between(previousDate, dateToday);
    int daysInBetween = (int)gap;
	
	LocalDate localDate = LocalDate.now();
	//format date into 'dd-MMM-yyyy' form 
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
	String currentDate = localDate.format(formatter).toUpperCase();
	//fetch only day from date and convert it into integer
	int dayNumber = Integer.parseInt(currentDate.substring(0,2));
	
    
	//method to fetch first date from system calendar of this week
	public  void firstDateOfWeek() {
		
		
		//format date into 'dd-MM-yyyy' form
		DateTimeFormatter formatterA = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
        //calculate no of days between current day and start day of week
		
		//fetch the date before no of days in between from system calendar
		String daysBefore = localDate.minus(daysInBetween,ChronoUnit.DAYS).format(formatter);
        System.out.println(daysBefore);
        dateArray.add(daysBefore);
        //fetch the month number
        int monthNumber = Integer.parseInt(localDate.minus(daysInBetween,ChronoUnit.DAYS).format(formatterA).substring(3,5));
       //call lastDateOfWeek method
        lastDateOfWeek();
        setCalendar(daysBefore,monthNumber);
        dateArray.add(daysBefore);
      
		
		
	}
	//method to fetch last date of each week
	public  void lastDateOfWeek() {
		int noOfDays = 7;
		
		
		//calculate the no of days to complete one week
		int completeOneWeek = noOfDays - daysInBetween-1;
	
		String daysAfter = localDate.plus(completeOneWeek,ChronoUnit.DAYS).format(formatter);
	    System.out.println(daysAfter);
	    dateArray.add(daysAfter);
	    //create a calendar and set year
		DateTimeFormatter formatterA = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		int monthNumber = Integer.parseInt(localDate.plus(completeOneWeek,ChronoUnit.DAYS).format(formatterA).substring(3,5));
      //  setCalendar(daysAfter,monthNumber);

	}
	
	public void setCalendar(String daysStartEnd,int monthNumber) {
		//create calendar instance
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, Integer.parseInt(daysStartEnd.substring(7,11)));
        //set month
        calendar.set(Calendar.MONTH,monthNumber-1);
        //set day
        calendar.set(Calendar.DAY_OF_MONTH,Integer.parseInt(daysStartEnd.substring(0,2)) );
      
        
        Date date = calendar.getTime();
        Instant instant = date.toInstant();
        LocalDate localDateA = instant.atZone(calendar.getTimeZone().toZoneId()).toLocalDate();

	    
	    for(int i=noOfWeek;i<3;i++) {
	         //fetch the date of weeks ago
		    LocalDate WeeksAgo = localDateA.minus(noOfWeek,ChronoUnit.WEEKS);
			//format the date
		    String dateWeeksAgo = WeeksAgo.format(formatter);
		    localDateA = WeeksAgo;
		    
			System.out.println(dateWeeksAgo);
			dateArray.add(dateWeeksAgo);
			 LocalDate WeeksaHead = WeeksAgo.plus(6,ChronoUnit.DAYS);
			 //format the date
			String dateWeeksaHead = WeeksaHead.format(formatter);
		   System.out.println(dateWeeksaHead);
		    dateArray.add(dateWeeksaHead);
		    

	    }	    
	    
	    
	}
	

    //method to check if timesheet date matches with suystem calendar
    public void dateVerification(String firstWeekInTimeSheet,String secondWeekInTimeSheet,String thirdWeekInTimeSheet) {
    	//get the date of current week
        String firstWeek = dateArray.get(0)+" To "+dateArray.get(1);
        System.out.println(firstWeek);
        //get the date of previous week
        String secondWeek = dateArray.get(2)+" To "+dateArray.get(3);
        System.out.println(secondWeek);
        //get the date of previous to previous week
        String thirdWeek = dateArray.get(4)+" To "+dateArray.get(5);
        System.out.println(thirdWeek);
        
      
            if((firstWeek.equalsIgnoreCase(firstWeekInTimeSheet))&&(secondWeek.equalsIgnoreCase(secondWeekInTimeSheet)&&(thirdWeek.equalsIgnoreCase(thirdWeekInTimeSheet)))) {
            	System.out.println("Date of timesheet matches with date of system calendar");
              }else {
            	  System.out.println("Date of timesheet does not matches with date of system calendar");
              }

	}

}
