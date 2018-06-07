package com.varun.webautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxesAutomation {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
							"/home/varunu28/Downloads/Softwares/Selenium/chromedriver");

		WebDriver driver = new ChromeDriver();
		
		driver.get("http://spicejet.com");
		
		// Checking the status of checkbox
		boolean checkMarked = driver.
				findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).
				isSelected();
		System.out.println("Checkbox Marked: " + checkMarked);
		
		// Clicking the checkbox
		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
		
		// Checking the status of checkbox
		checkMarked = driver.
						findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).
						isSelected();
		System.out.println("Checkbox Marked: " + checkMarked);
		
		driver.close();
	}
}
