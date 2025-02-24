package rk._4f.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage<HomePage> {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "email")
    private WebElement inputLoginEmail;
}
