package rk._4f.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static rk._4f.helpers.CustomInteraction.customClick;
import static rk._4f.helpers.CustomInteraction.customSendKeys;

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
        customClick(driver,buttonCouponAccordion);
        return this;
    }
}
