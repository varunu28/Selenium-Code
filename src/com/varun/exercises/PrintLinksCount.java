package com.varun.exercises;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintLinksCount {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
							"/home/varunu28/Downloads/Softwares/Selenium/chromedriver");

		WebDriver driver = new ChromeDriver();
		
		driver.get("http://qaclickacademy.com/practice.php");
		
		// Find count of links on the entire page
		int numOfLinks = driver.findElements(By.tagName("a")).size();
		System.out.println("Number of links on the page: " + numOfLinks);
		
		// Find count of links in the footer section by switching scope to footer
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		int numOfLinksFooter = footerDriver.findElements(By.tagName("a")).size();
		System.out.println("Number of links on the footer: " + numOfLinksFooter);
		
		// Find count of links in the first column of the footer section
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int numOfLinksColumnOne = columnDriver.findElements(By.tagName("a")).size();
		System.out.println("Number of links on the footer's first col: " + numOfLinksColumnOne);
		
		// Click on each link in the first column & open them in a new tab
		for (int i=1;i<numOfLinksColumnOne; i++) {
			 String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			 columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
		}
		
		// Find title of all pages including the parent page
		System.out.println("\n****Title of all the open pages****");
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		
		String parent = it.next();
		System.out.println("Parent Window: " + driver.switchTo().window(parent).getTitle());
		
		while (it.hasNext()) {
			System.out.println("Child Window: " + driver.switchTo().window(it.next()).getTitle());
		}
		
		driver.quit();
	}

}
