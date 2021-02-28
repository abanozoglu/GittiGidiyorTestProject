package resources;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    /*
    BasePage contains all selenium side methods.
    This methods using in the Page Object Classes.
     */

    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    //Click on the element using by element location (id, xpath, classname etc..)
    public void click(By elementLocation) {
        driver.findElement(elementLocation).click();
    }

    //Write text in the element using by element location (id, xpath, classname etc..)
    public void writeText(By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }

    public void pressEnterKey(By elementLocation){
        WebElement element = driver.findElement(elementLocation);
        element.sendKeys(Keys.ENTER);
    }

    public void scrollToEndOfThePage(){
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void selectFromDropdownByValue(By elementLocation, String value){
        WebElement testDropDown = driver.findElement(elementLocation);
        Select dropdown = new Select(testDropDown);
        dropdown.selectByValue(value);
    }
}
