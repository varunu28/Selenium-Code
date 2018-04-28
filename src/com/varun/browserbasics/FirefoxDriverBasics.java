package com.varun.browserbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverBasics {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", 
							"/home/varunu28/Downloads/Softwares/geckodriver");
		
		WebDriver driver = new FirefoxDriver();
		
		// Invoking a FireFox browser for Google
		driver.get("http://google.com");
		
		// Getting title of current page
		System.out.println(driver.getTitle());
	}
}
