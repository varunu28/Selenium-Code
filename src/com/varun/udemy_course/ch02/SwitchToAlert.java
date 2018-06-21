package com.varun.udemy_course.ch02;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToAlert {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                            "/home/varunu28/Downloads/Softwares/Selenium/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("http://formy-project.herokuapp.com/switch-window");

        WebElement alertButton = driver.findElement(By.id("alert-button"));
        alertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.quit();
    }
}
