package com.varun.webautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonAutomation {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", 
							"/home/varunu28/Downloads/Softwares/Selenium/chromedriver");

		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.echoecho.com/htmlforms10.htm");
		
		// Clicking on a radio button by using value tag
		driver.findElement(By.xpath("//input[@value='Butter']")).click();
		Thread.sleep(1000);
		
		// Finding number of group1 elements
		int numOfGroup1Elem = driver.
								findElements(By.xpath("//input[@name='group1']")).
								size();
		System.out.println(numOfGroup1Elem);
		
		// Clicking on a radio button for a particular attribute value
		for (int i=0; i<numOfGroup1Elem; i++) {
			if (driver.findElements(By.xpath("//input[@name='group1']")).get(i).getAttribute("value").equals("Milk")) {
				driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();
				Thread.sleep(1000);
				break;
			}
		}
		
		driver.close();
	}
}
