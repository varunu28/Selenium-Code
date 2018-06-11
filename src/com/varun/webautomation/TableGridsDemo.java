package com.varun.webautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableGridsDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
							"/home/varunu28/Downloads/Softwares/Selenium/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		int totalScore = 0;
		
		driver.get("http://www.cricbuzz.com/live-cricket-scorecard/18870/sco-vs-eng-only-odi-england-tour-of-scotland-2018");
		
		WebElement table = driver.
							findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
		
		int rowCount = table.
						findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).
						size();
		
		// Printing all the batting scores by parent to child transfer
		for (int i=0; i<rowCount-2; i++) {
			String score = table.
							findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).
							get(i).
							getText();
			totalScore += Integer.parseInt(score);
		}
		
		// Printing the extras & total by sibling to sibling transfer
		String extras = driver.
							findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).
							getText();
		totalScore += Integer.parseInt(extras);
		
		int onScreenTotal = Integer.parseInt(driver.
												findElement(By.xpath("//div[text()='Total']/following-sibling::div")).
												getText());
		
		if (totalScore == onScreenTotal) {
			System.out.println("Scores Match");
		}
		else {
			System.out.println("Scores Don't Match");
		}
		
		driver.quit();
	}
}
