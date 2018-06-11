package com.varun.webautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaximizeBrowserAndDeleteCookies {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
							"/home/varunu28/Downloads/Softwares/Selenium/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		// Maximizing the browser window
		driver.manage().window().maximize();
		
		// Deleting all cookies
		driver.manage().deleteAllCookies();
		
		driver.get("http://www.google.com");
		
		driver.quit();
	}

}
