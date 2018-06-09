package com.varun.webautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
							"/home/varunu28/Downloads/Softwares/Selenium/chromedriver");

		WebDriver driver = new ChromeDriver();
		
		// Maximizing the window
		driver.
			manage().
			window().
			maximize();
		
		driver.get("http://jqueryui.com/droppable");

		// Switching to frame by using a web element
		driver.
			switchTo().
			frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));

		Actions actions = new Actions(driver);
		
		// Performing a drag and drop element
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		actions.
			dragAndDrop(source, target).
			build().
			perform();
		
		Thread.sleep(1000);
		
		// Getting out of the selected frame & clicking on an element in the main page
		driver.
			switchTo().
			defaultContent();
		
		driver.
			findElement(By.xpath("//*[@id='content']/div[1]/ul/li[2]/a")).
			click();
		
		Thread.sleep(1000);
		
		driver.close();
	}
}
