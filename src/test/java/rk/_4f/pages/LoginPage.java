package rk._4f.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rk._4f.tests.BaseTest;

import java.time.Duration;

public class LoginPage extends BasePage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(name = "email")
    private WebElement inputLoginEmail;

    @FindBy(name = "password")
    private WebElement inputLoginPassword;

    public LoginPage clickButtonAllowCookies(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(buttonAllowCookies)).click();
        return this;
    }

    public LoginPage setInputLoginEmail(String email){
        inputLoginEmail.sendKeys(email);
        return this;
    }

    public LoginPage setInputLoginPassword(String password){
        inputLoginPassword.sendKeys(password);
        return this;
    }

}
