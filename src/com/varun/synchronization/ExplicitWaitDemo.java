package com.varun.synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", 
							"/home/varunu28/Downloads/Softwares/Selenium/chromedriver");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://alaskatrips.poweredbygps.com/g/pt/hotels?MDPCID=ALASKA-US.TPS.BRAND.hotels.HOTEL");
		
		driver.findElement(By.id("H-destination")).sendKeys("nyc");
		driver.findElement(By.id("H-destination")).sendKeys(Keys.TAB);
		
		// Go to the next page
		driver.findElement(By.id("H-fromDate")).sendKeys(Keys.ENTER);
		
		// Clicking on the first link after using explicit wait
		WebDriverWait driverWait = new WebDriverWait(driver, 10);
		
		driverWait.
			until(ExpectedConditions.
					elementToBeClickable(By.xpath("//*[@id='1623381']/div[2]/div/a")));
		driver.findElement(By.xpath("//*[@id='1623381']/div[2]/div/a")).click();
		
		driver.quit();
	}
}
