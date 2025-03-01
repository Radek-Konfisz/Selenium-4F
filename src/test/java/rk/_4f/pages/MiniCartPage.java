package rk._4f.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static rk._4f.helpers.CustomInteraction.customClick;

public class MiniCartPage extends BasePage<MiniCartPage> {

    public MiniCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.miniCart-root_open-mIU")
    private WebElement divMiniCart;

    @FindBy(xpath = "//div[contains(@class,'miniCart-toastContainer')]/span")
    private WebElement spanMessage;

    @FindBy(css = "a[href=\"/checkout-cart.html\"")
    private WebElement linkCartPage;

    public MiniCartPage clickCartPageLink() {
        customClick(driver, linkCartPage);
        return this;
    }

    public WebElement getDivMiniCart() {
        return divMiniCart;
    }

    public WebElement getSpanMessage() {
        return spanMessage;
    }
}
