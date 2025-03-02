package rk._4f.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test
    public void s01t01() {
        loginPage.clickMyAccountLink(); //Click the 'My account' link
        loginPage.sendKeysEmailInput(configFileReader.getProperty("email")) //Enter email
                .sendKeysPasswordInput(configFileReader.getProperty("password")) //Enter password
                .clickSignInButton(); //Click the 'Sign in' button
        Assert.assertTrue(loginPage.isDisplayedMyAccountDashboard()); //A user sees the account page
    }
}
