package rk._4f.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static rk._4f.helpers.CustomInteraction.*;

public class CartPage extends BasePage<CartPage>{

    public static final String CART_CODE_ADDED_MESSAGE = "Użyłeś kod kuponu";

    public CartPage(WebDriver driver) {
        super(driver);
    }

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

    public CartPage clickCouponAccordionButton(){
        customClick(driver,buttonCouponAccordion);
        return this;
    }

    public CartPage sendKeysCouponCodeInput(String code){
        customSendKeys(driver,inputCouponCode,code);
        return this;
    }

    public CartPage clickCouponCodeButton(){
        customClick(driver,buttonCouponCode);
        return this;
    }

    public String getDivToastMessageTest() {
        return customGetText(driver,divToastMessage);
    }

    public CartPage clickPlusQuantityButton(){
        customClick(driver,buttonPlusQuantity);
        return this;
    }

    public CartPage clickConfirmQuantityButton(){
        customClick(driver,buttonConfirmQuantity);
        return this;
    }

    public Boolean isGrandTotalBiggerThanValue(int value){
        return isBiggerThanValue(driver,spanGrandTotal,value);
    }

    public Boolean isGrandTotalSmallerThanValue(int value){
        return isSmallerThanValue(driver,spanGrandTotal,value);
    }

    public int getSpanGrandTotalValue() {
        return Integer.parseInt(customGetText(driver,spanGrandTotal));
    }
}
