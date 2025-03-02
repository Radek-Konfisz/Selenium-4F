package rk._4f.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static rk._4f.helpers.CustomInteraction.customClick;

public class BasePage<T> {


    protected WebDriver driver;
    @FindBy(id = "CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
    protected WebElement buttonAllowCookies;
    @FindBy(css = "a[href='/customer/account/login']")
    protected WebElement linkMyAccount;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public T clickAllowCookiesButton(String log) {
        customClick(driver, buttonAllowCookies, log);
        return (T) this;
    }

    public T clickMyAccountLink(String log) {
        customClick(driver, linkMyAccount, log);
        return (T) this;
    }

    public T waitForPageToReload() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("got interrupted!");
        }
        return (T) this;
    }

}
