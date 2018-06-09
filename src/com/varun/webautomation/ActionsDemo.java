package com.varun.webautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
							"/home/varunu28/Downloads/Softwares/Selenium/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.com");
		
		Actions actions = new Actions(driver);
		
		// Adding text to the search bar & selecting the text
		actions.
			moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).
			click().
			keyDown(Keys.SHIFT).
			sendKeys("hello").
			doubleClick().
			build().
			perform();
		Thread.sleep(1000);
		
		// Moving cursor to open the sign-in drop-down menu & right clicking it
		WebElement signInElement = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		actions.
			moveToElement(signInElement).
			contextClick().
			build().
			perform();
		Thread.sleep(1000);
		
		driver.close();
	}
}
