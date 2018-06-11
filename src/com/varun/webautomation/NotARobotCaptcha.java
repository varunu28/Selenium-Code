package com.varun.webautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NotARobotCaptcha {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
							"/home/varunu28/Downloads/Softwares/Selenium/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/recaptcha/api2/demo");
		
		// Selecting the frame for captcha & clicking it
		int frameNumber = findFrameId(driver, By.className("recaptcha-checkbox-checkmark"));
		driver.switchTo().frame(frameNumber);
		driver.findElement(By.className("recaptcha-checkbox-checkmark")).click();
		Thread.sleep(1000);
		
		driver.switchTo().defaultContent();
		
		// Selecting the frame for verification popup & clicking it
		int popupFrameNumber = findFrameId(driver, By.xpath(".//*[@id='recaptcha-verify-button']"));
		driver.switchTo().frame(popupFrameNumber);
		driver.findElement(By.xpath(".//*[@id='recaptcha-verify-button']")).click();
		
		driver.quit();
	}
	
	public static int findFrameId(WebDriver driver, By by) {
		
		int i;
		int frameCount = driver.findElements(By.tagName("iframe")).size();
		for (i=0; i<frameCount; i++) {
			driver.switchTo().frame(i);
			if (driver.findElements(by).size() > 0) {
				break;
			}
		}
		
		driver.switchTo().defaultContent();
		
		return i;
	}
}
