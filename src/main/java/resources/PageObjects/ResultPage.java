package resources.PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.BasePage;
import java.util.List;
import java.util.Random;


public class ResultPage extends BasePage {
    /*
    HomePage is a Page Object class. There is contains methods on the GittiGidiyor Result Page.
    This methods using in the test cases.
     */

    //Page Objects
    public static final String secondPageButtonXpath = "//a[text()='2']";
    public static final String productLinkClassName = "product-link";
    public String priceFromResultPage = "";

    public ResultPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //Page Methods
    public void goToSecondPageAndVerify(String searchItem){
        scrollToEndOfThePage();
        click(By.xpath(secondPageButtonXpath));
        Assert.assertEquals("https://www.gittigidiyor.com/arama/?k="+searchItem+"&sf=2",driver.getCurrentUrl());
    }

    public void selectRandomItem(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(productLinkClassName)));
        List<WebElement> list=driver.findElements(By.className(productLinkClassName));
        int webElementsSize = list.size();
        Random rand = new Random();
        int randomProductIndex = rand.nextInt(webElementsSize);
        System.out.println("Random Item Index Number is "+randomProductIndex);
//        priceFromResultPage = driver.findElement(By.xpath("(//p[@class='fiyat price-txt robotobold price'])["+randomProductIndex+"]")).getText();
//        System.out.println(priceFromResultPage);
        click(By.xpath("(//a[@class='product-link'])["+randomProductIndex+"]"));
    }

}
