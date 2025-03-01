package rk._4f.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static rk._4f.helpers.CustomInteraction.*;

public class LoginPage extends BasePage<LoginPage> {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "email")
    private WebElement inputEmail;

    @FindBy(name = "password")
    private WebElement inputPassword;

    @FindBy(xpath = "//div[contains(@class,'signIn-button')]/button")
    private WebElement signInButton;

    @FindBy(css = ".myAccount-dashboardRoot-lm6")
    private WebElement myAccountDashboard;

    public LoginPage sendKeysEmailInput(String email) {
        customSendKeys(driver,inputEmail,email);
        return this;
    }

    public LoginPage sendKeysPasswordInput(String password) {
        customSendKeys(driver,inputPassword,password);
        return this;
    }

    public LoginPage clickSignInButton() {
        customClick(driver,signInButton);
        return this;
    }

    public Boolean isDisplayedMyAccountDashboard() {
        return customIsDisplayed(driver, myAccountDashboard);
    }

}
