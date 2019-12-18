package com.epam.university.pagemodels.widgets;

import com.epam.university.pagemodels.pages.BasePage;
import com.epam.university.pagemodels.pages.SearchResultsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchWidget extends BasePage {

    private By searchField = By.id("gh-ac");
    private By categoryDropdownSelect = By.id("gh-cat");
    private By searchButton = By.id("gh-btn");

    public SearchWidget(WebDriver driver) {
        super(driver);
    }

    /**
     * Search for the product
     * @param productName
     */
    public void searchForProduct(String productName) {
        WebElement inputField = driver.findElement(searchField);

        inputField.clear();
        inputField.sendKeys(productName);
    }

    /**
     * Select the given category from the Category dropdown list
     * @param categoryName
     */
    public void selectCategory(String categoryName) {
        new Select(driver.findElement(categoryDropdownSelect)).selectByVisibleText(categoryName);
    }

    /**
     * Click on the Search button
     * @return SearchResultsPage
     */
    public SearchResultsPage clickOnSearchButton() {
        driver.findElement(searchButton).click();
        return new SearchResultsPage(driver);
    }
}
