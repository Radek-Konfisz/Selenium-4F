package rk._4f.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static rk._4f.helpers.CustomInteraction.*;

public class CartPage extends BasePage<CartPage>{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button[class*=\"accordion-title_container\"]")
    private WebElement buttonCouponAccordion;

    @FindBy(css = "input[class*=\"couponCode-input\"]")
    private WebElement inputCouponCode;

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

    public CartPage clickPlusQuantityButton(){
        customClick(driver,buttonPlusQuantity);
        return this;
    }

    public CartPage clickConfirmQuantityButton(){
        customClick(driver,buttonConfirmQuantity);
        return this;
    }

    public String getSpanGrandTotal() {
        return customGetText(driver,spanGrandTotal);
    }
}
