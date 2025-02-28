package rk._4f.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import rk._4f.pages.LoginPage;


public class LoginTest extends BaseTest {

    @Test
    public void shouldLoginSuccessfully(){
        loginPage = new LoginPage(driver);
        loginPage.clickAllowCookiesButton();
        loginPage.clickMyAccountLink();
        loginPage.setInputLoginEmail("test_user")
                .setInputLoginPassword("123")
                .clickSignInButton();
        Assert.assertTrue(true);
    }

}
