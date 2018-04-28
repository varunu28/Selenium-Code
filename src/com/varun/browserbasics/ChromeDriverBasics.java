package com.varun.browserbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverBasics {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
							"/home/varunu28/Downloads/Softwares/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		// Invoking a GoogleChrome browser for Google
		driver.get("http://google.com");
		
		// Getting title of current page
		System.out.println(driver.getTitle());
	}
}
