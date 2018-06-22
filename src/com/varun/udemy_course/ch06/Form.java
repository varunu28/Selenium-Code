package com.varun.udemy_course.ch06;

import com.varun.udemy_course.ch06.pages.ConfirmationPage;
import com.varun.udemy_course.ch06.pages.FormPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Form {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                            "/home/varunu28/Downloads/Softwares/Selenium/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("http://formy-project.herokuapp.com/form");

        FormPage formPage = new FormPage();
        formPage.submitForm(driver);

        ConfirmationPage confirmationPage = new ConfirmationPage();
        confirmationPage.waitForAlertBanner(driver);

        System.out.println(confirmationPage.getAlertBannerText(driver).
                            equals("The form was successfully submitted!"));

        driver.quit();
    }
}
