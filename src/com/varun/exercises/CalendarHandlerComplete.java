package com.varun.exercises;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarHandlerComplete {

	public static List<String> months = Arrays.asList("jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec");
	public static List<Integer> monthNums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
	
	public static void main(String[] args) throws InterruptedException {
		String month = "Jan";
		String day = "20";
		String year = "2019";
		
		// Getting today's date for verification of input date
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		String date = String.format(dtf.format(LocalDateTime.now()));  
		int yearToday = Integer.parseInt(date.split("-")[0]);
		int monthToday = Integer.parseInt(date.split("-")[1]);
		int dayToday = Integer.parseInt(date.split("-")[2]);
		int monthNum = monthNums.get(months.indexOf(month.toLowerCase().substring(0,3)));
		
		if (isValidDate(monthNum, Integer.parseInt(day), Integer.parseInt(year),
						monthToday, dayToday, yearToday)) {
			System.setProperty("webdriver.chrome.driver", 
								"/home/varunu28/Downloads/Softwares/Selenium/chromedriver");

			WebDriver driver = new ChromeDriver();
			
			driver.get("https://www.path2usa.com/travel-companions");

			selectDate(month, day, year, driver);
			
			driver.quit();
		}
		else {
			System.out.println("Invalid Date");
		}
	}

	public static boolean isValidDate(int m1, int d1, int y1, int m2, int d2, int y2) {
		if (y2 > y1) {
			return false;
		}
		else if (y2 == y1 && m2 > m1) {
			return false;
		}
		else if (y2 == y1 && m2 == m1 && d2 > d1) {
			return false;
		}
		
		return true;
	}
	
	public static void selectDate(String month, String day, String year, WebDriver driver) throws InterruptedException {

		// Clicking on date element
		driver.findElement(By.xpath(".//*[@id='travel_date']")).click();
		
		// Choosing the correct year
		String currMonthYear = driver.
								findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).
								getText();
		String currYear = currMonthYear.substring(currMonthYear.length()-4);
		
		String thClass = "";
		int compareFactor = year.compareTo(currYear);
		if (compareFactor > 0 && !currYear.equals(year)) {
			thClass = "next";
		}
		else if (compareFactor < 0 && !currYear.equals(year)) {
			thClass = "prev";
		}
		else {
			compareFactor = 0;
		}
		
		while(compareFactor != 0) {
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class=" + thClass + "]")).click();
			currMonthYear = driver.
								findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).
								getText();
			currYear = currMonthYear.substring(currMonthYear.length()-4);
			compareFactor = year.compareTo(currYear);
			Thread.sleep(1000);
		}
		
		// Choosing the correct month
		String currMonth = currMonthYear.substring(0, currMonthYear.length()-4);
		int monthNum = monthNums.get(months.indexOf(currMonth.toLowerCase().substring(0,3)));
		int requiredMonthNum = monthNums.get(months.indexOf(month.toLowerCase().substring(0,3)));
		
		if (monthNum > requiredMonthNum) {
			thClass = "prev";
		}
		else if (monthNum < requiredMonthNum) {
			thClass = "next";
		}
		
		while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains(month)) {
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class=" + thClass + "]")).click();
			Thread.sleep(1000);
		}
		
		// Choosing the correct day
		int count = driver.findElements(By.className("day")).size();
		
		for (int i=0;i<count;i++) {
			String dayText = driver.findElements(By.className("day")).get(i).getText();
			if (dayText.equalsIgnoreCase(day)) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}
		}
		
		Thread.sleep(1000);
	}
}
