package com.varun.webautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
							"/home/varunu28/Downloads/Softwares/Selenium/chromedriver");

		WebDriver driver = new ChromeDriver();
		
		// Initializing JS Executor
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		driver.get("https://www.ksrtc.in");
		
		// Creating Javascript script
		String script = "return document.getElementById(\"fromPlaceName\").value;";
		String target = "AIPORT";
		
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("BENG");
		
		int i = 0;
		while (i++ < 10) {
			driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
			Thread.sleep(1000);
			
			String textValue = (String) js.executeScript(script);
			if (textValue.contains(target.toUpperCase())) {
				System.out.println("FOUND: " + textValue);
				break;
			}
			else {
				System.out.println("NOT FOUND: " + textValue);
			}
		}
		
		driver.quit();
	}
}
