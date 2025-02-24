package rk._4f.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rk._4f.tests.BaseTest;

import java.time.Duration;

public class LoginPage extends BasePage<LoginPage> {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "email")
    private WebElement inputLoginEmail;

    @FindBy(name = "password")
    private WebElement inputLoginPassword;

    @FindBy(xpath = "//div[contains(@class,'signIn-button')]/button")
    private WebElement submitButton;

    public LoginPage setInputLoginEmail(String email){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(inputLoginEmail)).sendKeys(email);
        return this;
    }

    public LoginPage setInputLoginPassword(String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(inputLoginPassword)).sendKeys(password);
        return this;
    }

    public LoginPage clickSubmitButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        return this;
    }

}
