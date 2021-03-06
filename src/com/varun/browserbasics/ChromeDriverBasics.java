package com.varun.browserbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverBasics {

	public static void main(String[] args) {
		System.
			setProperty("webdriver.chrome.driver", 
						"/home/varunu28/Downloads/Softwares/Selenium/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		// Invoking a GoogleChrome browser for Google
		driver.get("https://google.co.in/");
		
		// Getting title of current page
		System.out.println(driver.getTitle());
		
		// Getting the URL of current page
		System.out.println(driver.getCurrentUrl());
		
		// Getting the page source of current page
		// System.out.println(driver.getPageSource());
		
		driver.get("http://yahoo.com");
		
		// Using the navigation function of Selenium
		driver.navigate().back();
		driver.navigate().forward(); 
		
		driver.close(); // Closes current browser
		driver.quit(); // Closes all browser started by Selenium
	}
}
