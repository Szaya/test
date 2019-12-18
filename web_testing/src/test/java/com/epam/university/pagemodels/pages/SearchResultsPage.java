package com.epam.university.pagemodels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultsPage extends BasePage {

    private By saveThisSearchButton = By.id("w11-follow-follow-faux-btn");
    private By numberOfResults = By.cssSelector("h1.srp-controls__count-heading span");
    private By resultLinks = By.className("s-item__link");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * check if the "Save search" button is displayed on the Search Results page
     * @return boolean
     */
    public boolean isSaveSearchButtonDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(this.saveThisSearchButton)));

        // toDo: Get the visibility of the button
        boolean isSearchButtonDisplayed = false;
        return isSearchButtonDisplayed;
    }

    /**
     * return the number of found products
     * @return int
     */
    public int getNumberOfResults() {
        return Integer.parseInt(driver.findElement(this.numberOfResults).getText().replace(",", ""));
    }

    public List<WebElement> getResultLinks() {
        return driver.findElements(resultLinks);
    }
}
