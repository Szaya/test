/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.university.tests;

import java.io.IOException;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.is;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Én
 */
public class homeworkTest extends TestBase {
    private final String bookingUrl = "https://www.booking.com";
    
    private final String destinationFieldSelector = "#frm > div.xp__fieldset.accommodation > div.xp__input-group.xp__search";
    private final String destinationTextInput = "Bali";
    
    private final String calendarOpenerSelector = "#frm > div.xp__fieldset.accommodation > div.xp__dates.xp__group";
    private final String calendarSelector = "#frm > div.xp__fieldset.accommodation > div.xp__dates.xp__group > div.xp-calendar > div";
    private final String calendarDateClass = "bui-calendar__date";
    private final String calendarDateSelectedValueName = "aria-selected";
    private final String calendarDec24Selector = "td[data-date='2019-12-24']";
    private final String calendarjan02Selector = "td[data-date='2020-01-02']";
    
    private final String searchButtonSelector = "#frm > div.xp__fieldset.accommodation > div.xp__button > div.sb-searchbox-submit-col.-submit-button > button";
    
    private final String searchResultTitleSelector = "#right > div:nth-child(5) > div > div.sr_header--title > div";
    
    private final String SearchResultDestinationClass = "c-autocomplete__input sb-searchbox__input sb-destination__input";
    private final String SearchResultDec24Selector = "#frm > div:nth-child(10) > div > div.sb-dates__grid.u-clearfix > div.sb-dates__col.--checkin-field > div > div > div.sb-date-field.b-datepicker > div > div.sb-date-field__display";
    private final String SearchResultDec24Text = "2019. december 24. (K)";
    private final String SearchResultJan02Selector = "#frm > div:nth-child(10) > div > div.sb-dates__grid.u-clearfix > div.sb-dates__col.--checkout-field > div > div > div.sb-date-field.b-datepicker > div > div.sb-date-field__display";
    private final String SearchResultJan02Text = "2020. január 2. (Cs)";
    
    private final String breakfestSelector = "#filterbox_options > div > div:nth-child(4) > div.filteroptions > a.filterelement.bui-checkbox.active";
    private final String freeWifiSelector = "#filterbox_options > div > div:nth-child(4) > div.filteroptions > a:nth-child(7)";
    private final String activeCheckboxClass = "filterelement bui-checkbox  active";
    
    @Test
    public void searchForBaliTest() {
        driver.get(bookingUrl);
        
        // add Bali to destination
        WebElement inputSearch = driver.findElement(By.cssSelector(destinationFieldSelector));
        Assert.assertTrue ("The search input field isn't displayed!", isWebElementDisplayed(inputSearch));
        Assert.assertEquals(destinationTextInput, inputSearch.getAttribute("value"));

        //check the claendar opener button
        WebElement calendarOpener = driver.findElement(By.cssSelector(calendarOpenerSelector));
        Assert.assertTrue ("The calendar opener button is not displayed!", isWebElementDisplayed(calendarOpener));
        
        //check the calendar
        calendarOpener.click();
        WebElement calendar = driver.findElement(By.cssSelector(calendarSelector));
        Assert.assertTrue ("The calendar is not displayed!", isWebElementDisplayed(calendar));
        
        //select dec 24
        WebElement dec24Button = driver.findElement(new ByChained(By.className(calendarDateClass), By.cssSelector(calendarDec24Selector)));
        Assert.assertTrue ("Dec 24 button is not displayed!", isWebElementDisplayed(dec24Button));
        dec24Button.click();
        Assert.assertEquals("Can't select dec24 in the calendar.", "true", dec24Button.getAttribute(calendarDateSelectedValueName));
        
        //select jan 02
        WebElement jan02Button = driver.findElement(new ByChained(By.className(calendarDateClass), By.cssSelector(calendarjan02Selector)));
        Assert.assertTrue ("Jan. 02. button is not displayed!", isWebElementDisplayed(jan02Button));
        jan02Button.click();
        Assert.assertEquals("Can't select jan. 02. in the calendar.", "true", jan02Button.getAttribute(calendarDateSelectedValueName));
        
        //push the search button
        WebElement searchButton = driver.findElement(new ByChained(By.cssSelector(searchButtonSelector)));
        Assert.assertTrue ("The search button is not displayed!", isWebElementDisplayed(searchButton));
        searchButton.click();
        
        //check the search has finished
        WebElement searchResultTitle = driver.findElement(new ByChained(By.cssSelector(searchResultTitleSelector)));
        Assert.assertTrue ("The result wan't succesful.", isWebElementDisplayed(searchResultTitle));
        
        //check the destination value
        WebElement resultDestination = driver.findElement(By.className(SearchResultDestinationClass));
        Assert.assertTrue ("The result destination is not displayed!", isWebElementDisplayed(resultDestination));
        Assert.assertEquals("The search result field is not" + destinationTextInput, destinationTextInput, resultDestination.getAttribute("value"));
        
        //check result dec 24
        WebElement resultDateDec24 = driver.findElement(By.cssSelector(SearchResultDec24Selector));
        Assert.assertTrue ("The result date dec 24 is not displayed!", isWebElementDisplayed(resultDateDec24));
        Assert.assertEquals("The search result date is not dec 24.", SearchResultDec24Text, resultDateDec24.getText());
        
        //check result jan 02
        WebElement resultDateJan02 = driver.findElement(By.cssSelector(SearchResultJan02Selector));
        Assert.assertTrue ("The result date dec 24 is not displayed!", isWebElementDisplayed(resultDateJan02));
        Assert.assertEquals("The search result date is not jan 02." ,SearchResultJan02Text, resultDateJan02.getText());
        
        
        //check the breakfast
        WebElement breakfast = driver.findElement(By.cssSelector(breakfestSelector));
        Assert.assertTrue ("The Breakfast Is Included checkbutton is not displayed!", isWebElementDisplayed(breakfast));
        breakfast.click();
        Assert.assertEquals("The breakfast selection wasn't success." ,activeCheckboxClass, breakfast.getClass());
        
         //check the free wifi
        WebElement freeWifi = driver.findElement(By.cssSelector(freeWifiSelector));
        Assert.assertTrue ("The free wifi checkbox is not displayed!", isWebElementDisplayed(freeWifi));
        freeWifi.click();
        Assert.assertEquals("The freewifit selection wasn't success." ,activeCheckboxClass, freeWifi.getClass());
        
        try {
            this.takeScreenshot ("SearchForBaliResult");
        } catch (IOException e) {
            e.printStackTrace();
            Assert.assertTrue ("Can't takescreenshot!", true);
        }
    }
    
    public boolean isWebElementDisplayed(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        
        return element.isDisplayed();
    }
}
