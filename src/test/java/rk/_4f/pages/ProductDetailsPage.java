package rk._4f.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage<ProductDetailsPage>{

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (css = "button[title=\"L\"]")
    private WebElement buttonLSize;

    @FindBy (css = "xpath = //div[contains(@class,'addToCartActions')]/button")
    private WebElement buttonAddToCart;
}
