package resources.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.BasePage;


public class ProductPage extends BasePage {
    /*
    ProductPage is a Page Object class. There is contains methods on the GittiGidiyor Product Page.
    This methods using in the test cases.
     */

    //Page Objects
    public static final String addToBasketId = "add-to-basket";
    public static final String basketTitleClassName = "basket-title";

    public ProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //Page Methods
    public void addToBasket(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(addToBasketId)));
        scrollToEndOfThePage();
        click(By.id(addToBasketId));
    }

    public void goToBasket(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(basketTitleClassName)));
        click(By.className(basketTitleClassName));
    }

}
