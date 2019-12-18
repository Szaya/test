package com.epam.university.pagemodels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {

    private By productTitle = By.id("itemTitle");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Get the Product title
     * @return title
     */
    public String getProductTitle() {
        // toDo: get the product title
        String title = null;
        return title;
    }
}
