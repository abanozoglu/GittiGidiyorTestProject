package resources.PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.BasePage;

public class LoginPage extends BasePage {
    /*
    LoginPage is a Page Object class. There is contains methods on the GittiGidiyor Login Page.
    This methods using in the test cases.
     */

    //Page Objects
    public static final String loginPageUrl = "https://www.gittigidiyor.com/uye-girisi";
    public static final String usernameTextboxId="L-UserNameField";
    public static final String passwordTextboxId="L-PasswordField";
    public static final String loginButtonId="gg-login-enter";
    public static final String profileNameTextElement="//div[@title='Hesabım']//div//span";


    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //Page Methods
    public void openTheLoginScreen() {
        driver.get(loginPageUrl);
        Assert.assertEquals(loginPageUrl,driver.getCurrentUrl());
    }

    public void writeUserName(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(usernameTextboxId)));
        writeText(By.id(usernameTextboxId), username);
    }

    public void writePassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(passwordTextboxId)));
        writeText(By.id(passwordTextboxId), password);
    }

    public void clickLoginButtonAndVerifyUserIsLogin(String profileName)  {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loginButtonId)));
        click(By.id(loginButtonId));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(profileNameTextElement)));
        String actualProfileName = driver.findElement(By.xpath(profileNameTextElement)).getText();
        Assert.assertEquals(profileName,actualProfileName);
    }
}
