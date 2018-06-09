package com.varun.exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarHandler {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
							"/home/varunu28/Downloads/Softwares/Selenium/chromedriver");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.path2usa.com/travel-companions");
		
		String month = "August";
		String day = "20";
		
		// Clicking on date element
		driver.findElement(By.xpath(".//*[@id='travel_date']")).click();
		
		// Choosing the correct month
		while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains(month)) {
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
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
		
		driver.quit();
	}

}
