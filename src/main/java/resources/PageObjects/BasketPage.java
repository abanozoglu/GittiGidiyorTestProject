package resources.PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.BasePage;


public class BasketPage extends BasePage {
    /*
    BasketPage is a Page Object class. There is contains methods on the GittiGidiyor BasketPage.
    This methods using in the test cases.
     */

    //Page Objects
    public static final String sepetimPageUrl = "https://www.gittigidiyor.com/sepetim";
    public static final String amountDropdownXpath = "//select";
    public static final String totalAmountTextXpath = "//div[@class='gg-d-16 detail-text']";
    public static final String totalAmountExpectedText = "Ürün Toplamı (2 Adet)";
    public static final String deleteButtonXpath = "//a[@title='Sil']";
    public static final String itemDeletedTextXpath = "(//h2)[1]";
    public static final String itemDeletedExpectedText = "Sepetinizde ürün bulunmamaktadır.";

    public BasketPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //Page Methods
    public void verifyPageOpened(){
        Assert.assertEquals(sepetimPageUrl,driver.getCurrentUrl());
    }

    public void increaseTheAmountAndVerify() throws InterruptedException {
        selectFromDropdownByValue(By.xpath(amountDropdownXpath),"2");
        Thread.sleep(2000);
        String actualTextOfTotalAmount = driver.findElement(By.xpath(totalAmountTextXpath)).getText();
        Assert.assertEquals(totalAmountExpectedText,actualTextOfTotalAmount);
    }

    public void deleteItemAndVerify() throws InterruptedException {
        click(By.xpath(deleteButtonXpath));
        Thread.sleep(2000);
        String actualDeletedText = driver.findElement(By.xpath(itemDeletedTextXpath)).getText();
        Assert.assertEquals(itemDeletedExpectedText,actualDeletedText);
    }

}
