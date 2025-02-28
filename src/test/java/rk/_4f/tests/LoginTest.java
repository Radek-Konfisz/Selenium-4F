package rk._4f.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import rk._4f.pages.LoginPage;

import java.time.Duration;


public class LoginTest extends BaseTest {

    @Test
    public void shouldLoginSuccessfully(){
        loginPage = new LoginPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement myAccountDashboard = loginPage.getMyAccountDashboard();

        loginPage.clickAllowCookiesButton();
        loginPage.clickMyAccountLink();
        loginPage.setEmailInput(configFileReader.getProperty("email"))
                .setPasswordInput(configFileReader.getProperty("password"))
                .clickSignInButton();
        Assert.assertTrue(wait.until(d -> myAccountDashboard.isDisplayed()));
    }
}
