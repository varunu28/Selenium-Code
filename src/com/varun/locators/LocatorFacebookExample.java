package com.varun.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorFacebookExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
							"/home/varunu28/Downloads/Softwares/Selenium/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		// Opening a browser for Facebook
		driver.get("https://facebook.com");
		
		// Passing a text to the element with "email" id
		driver.findElement(By.id("email")).sendKeys("abc@xyz.com");
		
		// Passing a text to the element with "password" name attribute
		driver.findElement(By.name("pass")).sendKeys("password");
		
		// Locating an element using the linked text
		driver.findElement(By.linkText("Forgot account?")).click();
	}
}