package rk._4f.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static rk._4f.helpers.CustomInteraction.customClick;
import static rk._4f.helpers.CustomInteraction.customIsDisplayed;

public class MiniCartPage extends BasePage<MiniCartPage> {

    //Expected value of spanMessage
    public static final String MINI_CART_ADD_TO_CART_MESSAGE = "DODANO DO KOSZYKA";

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

    public Boolean isDisplayedDivMiniCart() {
        return customIsDisplayed(driver, divMiniCart);
    }

    public String getSpanMessage() {
        return spanMessage.getText();
    }
}
