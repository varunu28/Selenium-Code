package com.varun.udemy_course.ch02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeyboardAndMouseInput {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                            "/home/varunu28/Downloads/Softwares/Selenium/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("http://formy-project.herokuapp.com/keypress");

        WebElement nameElement = driver.findElement(By.id("name"));
        nameElement.sendKeys("Varun Upadhyay");

        WebElement button = driver.findElement(By.id("button"));
        button.click();

        driver.quit();
    }
}
