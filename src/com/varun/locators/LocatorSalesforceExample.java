package com.varun.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorSalesforceExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
							"/home/varunu28/Downloads/Softwares/Selenium/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		// Opening a browser for Salesforce Login
		driver.get("https://login.salesforce.com");
		
		// Passing a text to the element with "username" id
		driver.findElement(By.id("username")).sendKeys("hello");
		
		// Passing a text to the element with "pw" name attribute
		driver.findElement(By.name("pw")).sendKeys("password");
		
		// Clicking a login element using Xpath
		driver.findElement(By.xpath("//*[@id='Login']")).click();
		
		driver.close();
	}
}