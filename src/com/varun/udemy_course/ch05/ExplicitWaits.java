package com.varun.udemy_course.ch05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaits {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                            "/home/varunu28/Downloads/Softwares/Selenium/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("http://formy-project.herokuapp.com/autocomplete");

        WebElement autocomplete = driver.findElement(By.id("autocomplete"));
        autocomplete.sendKeys("1326 The Alameda, San Jose, CA");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement autocompleteResult = wait.until(ExpectedConditions.
                                            visibilityOfElementLocated(By.className("pac-item")));

        autocompleteResult.click();

        driver.quit();
    }
}
