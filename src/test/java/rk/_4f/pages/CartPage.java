package rk._4f.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static rk._4f.helpers.CustomInteraction.*;

public class CartPage extends BasePage<CartPage> {

    public static final String CART_CODE_ADDED_MESSAGE = "Użyłeś kod kuponu";
    @FindBy(css = "button[class*=\"accordion-title_container\"]")
    private WebElement buttonCouponAccordion;
    @FindBy(css = "input[class*=\"couponCode-input\"]")
    private WebElement inputCouponCode;
    @FindBy(css = "button[class*=\"couponCode-button\"]")
    private WebElement buttonCouponCode;
    @FindBy(xpath = "//div[contains(@class,'toast-message')]")
    private WebElement divToastMessage;
    @FindBy(css = "button[class*=\"quantity-plus\"")
    private WebElement buttonPlusQuantity;
    @FindBy(css = "button[class*=\"quantity-confirm\"]")
    private WebElement buttonConfirmQuantity;
    @FindBy(xpath = "//div[contains(@class,'summary-grandTotal')]/span[contains(@class,'summary-amount')]/span")
    private WebElement spanGrandTotal;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage clickCouponAccordionButton(String log) {
        customClick(driver, buttonCouponAccordion, log);
        return this;
    }

    public CartPage sendKeysCouponCodeInput(String code, String log) {
        customSendKeys(driver, inputCouponCode, code, log);
        return this;
    }

    public CartPage clickCouponCodeButton(String log) {
        customClick(driver, buttonCouponCode, log);
        return this;
    }

    public String getDivToastMessageTest(String log) {
        return customGetText(driver, divToastMessage, log);
    }

    public CartPage clickPlusQuantityButton(String log) {
        customClick(driver, buttonPlusQuantity, log);
        return this;
    }

    public CartPage clickConfirmQuantityButton(String log) {
        customClick(driver, buttonConfirmQuantity, log);
        return this;
    }

    public Boolean isGrandTotalBiggerThanValue(int value, String log) {
        return isBiggerThanValue(driver, spanGrandTotal, value, log);
    }

    public Boolean isGrandTotalSmallerThanValue(int value, String log) {
        return isSmallerThanValue(driver, spanGrandTotal, value, log);
    }

    public int getSpanGrandTotalValue(String log) {
        return Integer.parseInt(customGetText(driver, spanGrandTotal, log));
    }
}
