package com.varun.webautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementValidation {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
							"/home/varunu28/Downloads/Softwares/Selenium/chromedriver");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://us.makemytrip.com/");
		
		// Checking if return date tab is hidden or not
		System.out.println("Before clicking multi-city radio button:");
		System.out.println(driver.
							findElement(By.
										xpath("//*[@id=\"top_content\"]/div[2]/div[2]/div[2]/div[1]/div[7]/span/span[4]/label[1]")).
							isDisplayed());
		
		// Clicking on multi-city radio button
		driver.findElement(By.xpath("//*[@id=\"trip_type\"]/label[3]")).click();
		Thread.sleep(1000);
		
		// Checking if return date tab is hidden or not
		System.out.println("Before clicking multi-city radio button:");
		System.out.println(driver.
				findElement(By.
							xpath("//*[@id=\"top_content\"]/div[2]/div[2]/div[2]/div[1]/div[7]/span/span[4]/label[1]")).
				isDisplayed());
		
		// To check if an element is present or not
		int numOfElements = driver.findElements(By.xpath("//*[@id=\"trip_type\"]/label[4]")).size();
		if(numOfElements == 0) {
			System.out.println("Element not present");
		}
		else {
			System.out.println("Element is present");
		}
		
		driver.close();
	}
}
