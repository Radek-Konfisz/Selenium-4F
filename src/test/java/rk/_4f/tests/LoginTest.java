package rk._4f.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test
    public void s01t01() {
        loginPage.clickMyAccountLink("Step: Click the 'My account' link");
        loginPage.sendKeysEmailInput(configFileReader.getProperty("email"), "Step: Enter email")
                .sendKeysPasswordInput(configFileReader.getProperty("password"), "Step: Enter password")
                .clickSignInButton("Step: Click the 'Sign in' button");
        Assert.assertTrue(loginPage.isDisplayedMyAccountDashboard("Expected: A user sees the account page"));
    }
}
