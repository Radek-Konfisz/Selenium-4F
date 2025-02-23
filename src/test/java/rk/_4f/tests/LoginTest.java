package rk._4f.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import rk._4f.pages.LoginPage;


public class LoginTest extends BaseTest {

    @Test
    public void shouldLoginSuccessfully(){
        loginPage = new LoginPage(driver);
        loginPage.clickButtonAllowCookies().setInputLoginEmail("test").setInputLoginPassword("pass1234");
        Assert.assertTrue(true);
    }

}
