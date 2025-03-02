package rk._4f.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static rk._4f.helpers.CustomInteraction.*;

public class LoginPage extends BasePage<LoginPage> {

    @FindBy(name = "email")
    private WebElement inputEmail;
    @FindBy(name = "password")
    private WebElement inputPassword;
    @FindBy(xpath = "//div[contains(@class,'signIn-button')]/button")
    private WebElement signInButton;
    @FindBy(css = ".myAccount-dashboardRoot-lm6")
    private WebElement myAccountDashboard;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage sendKeysEmailInput(String email, String log) {
        customSendKeys(driver, inputEmail, email, log);
        return this;
    }

    public LoginPage sendKeysPasswordInput(String password, String log) {
        customSendKeys(driver, inputPassword, password, log);
        return this;
    }

    public LoginPage clickSignInButton(String log) {
        customClick(driver, signInButton, log);
        return this;
    }

    public Boolean isDisplayedMyAccountDashboard(String log) {
        return customIsDisplayed(driver, myAccountDashboard, log);
    }

}
