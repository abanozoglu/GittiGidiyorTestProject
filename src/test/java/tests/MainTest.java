package tests;

import com.sun.jmx.remote.util.ClassLogger;
import org.junit.Before;
import org.junit.Test;
import resources.BasePage;
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
        loginPage.writeUserName("okxhimxrjnxcqdyksy@kiabws.com");
        loginPage.writePassword("Test123456789");
        loginPage.clickLoginButtonAndVerifyUserIsLogin("tstsrgttgdyr");
    }

    @Test
    public void test3SearchAndGoToSecondPageAndVerify(){
        homePage.searchInHomePage("bilgisayar");
        resultPage.goToSecondPageAndVerify("bilgisayar");
    }

    @Test
    public void test4SelectRandomItemAndAddToBasket() throws InterruptedException {
        resultPage.selectRandomItem();
        productPage.addToBasket();
        productPage.goToBasket();
        basketPage.verifyPageOpened();
        basketPage.increaseTheAmountAndVerify();
        basketPage.deleteItemAndVerify();
    }
}
