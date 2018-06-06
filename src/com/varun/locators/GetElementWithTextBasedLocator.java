package com.varun.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetElementWithTextBasedLocator {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", 
							"/home/varunu28/Downloads/Softwares/Selenium/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("http://qaclickacademy.com/interview.php");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()=' Selenium ']")).click();
		Thread.sleep(1000);
		
		driver.close();
	}
}
