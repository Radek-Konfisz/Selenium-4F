package rk._4f.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import rk._4f.pages.LoginPage;


public class LoginTest extends BaseTest {

    @Test
    public void s01t01() {
        loginPage = new LoginPage(driver);

        loginPage.clickMyAccountLink();
        loginPage.sendKeysEmailInput(configFileReader.getProperty("email"))
                .sendKeysPasswordInput(configFileReader.getProperty("password"))
                .clickSignInButton();
        Assert.assertTrue(loginPage.isDisplayedMyAccountDashboard());
    }
}
