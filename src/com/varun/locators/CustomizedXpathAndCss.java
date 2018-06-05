package com.varun.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomizedXpathAndCss {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
							"/home/varunu28/Downloads/Softwares/Selenium/chromedriver");

		WebDriver driver = new ChromeDriver();
		
		// Opening a browser for Facebook
		driver.get("https://www.facebook.com");
		
		// Doing the login using customized xpath
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("email-address");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("password");
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		
		// Doing the login using customized CSS
		driver.get("https://www.facebook.com");
		
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("email-address");
		driver.findElement(By.cssSelector("[id='pass']")).sendKeys("password");
		driver.findElement(By.cssSelector("[value='Log In']")).click();
	
		driver.close();
	}
}
