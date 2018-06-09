package com.varun.webautomation;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleMultipleWindowsDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
							"/home/varunu28/Downloads/Softwares/Selenium/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Opening signup page
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F%3Fpc%3Dtopnav-about-en&flowName=GlifWebSignIn&flowEntry=SignUp");
		
		// Opening the terms page link
		driver.findElement(By.xpath("//*[@id='initialView']/footer/ul/li[2]/a")).click();
		Thread.sleep(1000);
		
		// It prints the parent's window title by default 
		System.out.println("Before switching(Parent): " + driver.getTitle());
		
		// Getting the child's window title
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> it = windowIds.iterator();
		
		String parentId = it.next();
		String childId = it.next();
		
		driver.switchTo().window(childId);
		System.out.println("After switching(Child): " + driver.getTitle());
		
		// Again switching to parent window & getting the title
		driver.switchTo().window(parentId);
		System.out.println("After switching(Parent): " + driver.getTitle());
		
		driver.quit();
	}
}
