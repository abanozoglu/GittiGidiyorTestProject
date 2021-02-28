package resources.PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.BasePage;

public class HomePage extends BasePage {
    /*
    HomePage is a Page Object class. There is contains methods on the GittiGidiyor Home Page.
    This methods using in the test cases.
     */

    //Page Objects
    public static final String baseURL = "https://www.gittigidiyor.com/";
    public static final String searchBarXpath = "//input[@data-cy='header-search-input']";
    public static final String searchResultKeyXpath = "//span[@class='search-result-keyword']";

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //Page Methods
    //Go to base URL using baseURL variable
    public void goTo (){
        driver.get(baseURL);
    }

    //Verifying HomePage Loaded with get current url
    public void verifyHomePageLoaded(){
        Assert.assertEquals(baseURL,driver.getCurrentUrl());
    }

    public void searchInHomePage(String searchItem){
        writeText(By.xpath(searchBarXpath),searchItem);
        pressEnterKey(By.xpath(searchBarXpath));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchResultKeyXpath)));
        String actualSearchResultKey = driver.findElement(By.xpath(searchResultKeyXpath)).getText();
        Assert.assertEquals(searchItem,actualSearchResultKey);
    }

}
