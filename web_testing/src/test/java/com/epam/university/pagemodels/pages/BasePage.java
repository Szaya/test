package com.epam.university.pagemodels.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToEbay(WebDriver driver) {
        driver.get("https://ebay.com");
    }
}
