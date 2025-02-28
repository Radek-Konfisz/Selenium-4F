package rk._4f.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    public LoginPage setEmailInput(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> inputEmail.isDisplayed());
        inputEmail.sendKeys(email);
        return this;
    }

    public LoginPage setPasswordInput(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> inputPassword.isDisplayed());
        inputPassword.sendKeys(password);
        return this;
    }

    public LoginPage clickSignInButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
        return this;
    }

    public WebElement getMyAccountDashboard() {
        return myAccountDashboard;
    }

}
