package com.varun.udemy_course.ch02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollToElement {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                            "/home/varunu28/Downloads/Softwares/Selenium/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("http://formy-project.herokuapp.com/scroll");

        WebElement name = driver.findElement(By.id("name"));

        Actions actions = new Actions(driver);

        actions.moveToElement(name);
        name.sendKeys("Varun Upadhyay");

        WebElement date = driver.findElement(By.id("date"));
        date.sendKeys("01/01/2020");

        driver.quit();
    }
}
