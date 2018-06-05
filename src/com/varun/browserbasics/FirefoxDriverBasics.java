package com.varun.browserbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverBasics {

	public static void main(String[] args) {
		System.
			setProperty("webdriver.gecko.driver", 
						"/home/varunu28/Downloads/Softwares/Selenium/geckodriver");
		
		WebDriver driver = new FirefoxDriver();
		
		// Invoking a FireFox browser for Facebook
		driver.get("http://facebook.com");
		
		// Using cssSelector & xpath using Firefox
		driver.findElement(By.cssSelector("#email")).sendKeys("email-address");
		driver.findElement(By.xpath("//*[@id=\'pass\']")).sendKeys("password");
		
		// Clicking on forgot password button
		driver.findElement(By.xpath("//*[@id=\'login_form\']/table/tbody/tr[3]/td[2]/div/a")).click();
		
		driver.close();
	}
}