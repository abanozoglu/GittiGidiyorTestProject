package tests;

import com.sun.jmx.remote.util.ClassLogger;
import org.junit.Before;
import org.junit.Test;
import resources.PageObjects.*;
import org.apache.log4j.Logger;

public class MainTest extends BaseTest{

    private static Logger log  = Logger.getLogger(ClassLogger.class.getName());

    private HomePage homePage;
    private LoginPage loginPage;
    private ResultPage resultPage;
    private ProductPage productPage;
    private BasketPage basketPage;

    @Before
    public void initialize() {
        homePage = new HomePage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        resultPage = new ResultPage(driver, wait);
        productPage = new ProductPage(driver,wait);
        basketPage = new BasketPage(driver,wait);
    }

    //Go to the url “www.gittigidiyor.com”
    @Test()
    public void test1GoToGittiGidiyorAndVerify(){
        homePage.goTo();
        log.info("Page Opened");
        homePage.verifyHomePageLoaded();
        log.info("Page Opening Verified");
    }

    @Test
    public void test2LoginToGittiGidiyorAndVerify() {
        loginPage.openTheLoginScreen();
        log.info("Login Screen Opened");
        loginPage.writeUserName("okxhimxrjnxcqdyksy@kiabws.com");
        log.info("Username Entered");
        loginPage.writePassword("Test123456789");
        log.info("Password Entered");
        loginPage.clickLoginButtonAndVerifyUserIsLogin("tstsrgttgdyr");
        log.info("Login Button Clicked");
    }

    @Test
    public void test3SearchAndGoToSecondPageAndVerify(){
        homePage.searchInHomePage("bilgisayar");
        log.info("bilgisayar keyword searched");
        resultPage.goToSecondPageAndVerify("bilgisayar");
        log.info("Second Page Opened and Verify");
    }

    @Test
    public void test4SelectRandomItemAndAddToBasket() throws InterruptedException {
        resultPage.selectRandomItem();
        log.info("Random Item Selected From Search Page");
        productPage.addToBasket();
        log.info("Item Added to Basket");
        productPage.goToBasket();
        log.info("Basket Page is Opened");
        basketPage.verifyPageOpened();
        log.info("Verify the Basket Page is Opened");
        basketPage.increaseTheAmountAndVerify();
        log.info("Total Amount Increased and Verified");
        basketPage.deleteItemAndVerify();
        log.info("Item Deleted from Basket");
    }
}
