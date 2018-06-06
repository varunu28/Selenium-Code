package com.varun.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SiblingTraversalWithXpath {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", 
							"/home/varunu28/Downloads/Softwares/Selenium/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("http://qaclickacademy.com/interview.php");
		
		driver.findElement(By.xpath("//*[@id='tablist1-tab1']")).click();
		
		for (int i=1;i<=3;i++) {
			driver.findElement(By.xpath("//*[@id='tablist1-tab1']/following-sibling::li[" + String.valueOf(i) + "]")).
				click();
			Thread.sleep(1000);
		}	
		
		driver.close();
	}
}
