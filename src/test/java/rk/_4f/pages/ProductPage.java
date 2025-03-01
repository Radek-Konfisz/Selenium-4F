package rk._4f.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static rk._4f.helpers.CustomInteraction.customClick;

public class ProductPage extends BasePage<ProductPage>{

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (css = "button[title='L']")
    private WebElement buttonLSize;

    @FindBy (xpath = "//div[contains(@class,'addToCartActions')]/button")
    private WebElement buttonAddToCart;

    public ProductPage clickLSizeButton(){
        customClick(driver,buttonLSize);
        return this;
    }

    public ProductPage clickAddToCartButton(){
        customClick(driver,buttonAddToCart);
        return this;
    }
}
