package com.varun.webautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaPopupsAutomation {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
							"/home/varunu28/Downloads/Softwares/Selenium/chromedriver");

		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.tizag.com/javascriptT/javascriptalert.php");
	
		// CLicking on the popup generator
		driver.
			findElement(By.
						xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/form/input")).
			click();
		Thread.sleep(1000);
		
		// Getting the text from the popup
		System.out.println(driver.switchTo().alert().getText());
		
		// Accepting the popup
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		
		driver.close();
	}
}
