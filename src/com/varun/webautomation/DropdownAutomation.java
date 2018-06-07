package com.varun.webautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownAutomation {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
							"/home/varunu28/Downloads/Softwares/Selenium/chromedriver");

		WebDriver driver = new ChromeDriver();
		
		driver.get("http://spicejet.com");
		
		// Selecting the currency element in the static dropdown
		Select select = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		
		select.selectByValue("AED");
		select.selectByIndex(3);
		select.selectByVisibleText("INR");
		Thread.sleep(1000);
		
		// Selecting destination element in dynamic dropdown
		driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='GOI']")).click();
		Thread.sleep(1000);
		
		// Wrapping the xpath for finding the second instance
		driver.findElement(By.xpath("(//a[@value='DEL'])[2]")).click();
		Thread.sleep(1000);
		
		driver.close();
	}
}
