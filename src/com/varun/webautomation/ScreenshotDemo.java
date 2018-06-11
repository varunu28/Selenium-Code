package com.varun.webautomation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotDemo {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", 
							"/home/varunu28/Downloads/Softwares/Selenium/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		// Maximizing the browser window
		driver.manage().window().maximize();
		
		driver.get("http://www.google.com");
		
		// Casting driver to take screenshot in file format
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("/home/varunu28/Desktop/screenshot.png"));
		
		driver.quit();
	}
}
