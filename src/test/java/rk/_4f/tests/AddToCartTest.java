package rk._4f.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static rk._4f.pages.MiniCartPage.MINI_CART_ADD_TO_CART_MESSAGE;

public class AddToCartTest extends BaseTest {


    @Test
    public void s02t01() {
        driver.get(PRODUCT_URL);
        Reporter.log("Step: Navigate to the product page");
        productPage.clickLSizeButton("Step: Click the Variant Option button")
                .clickAddToCartButton("Step: Click the Add to cart button");
        Assert.assertTrue(miniCartPage.isDisplayedDivMiniCart("Expected: A mini cart slides out"));
        Assert.assertEquals(miniCartPage.getSpanMessage("Expected: There is an information about the product being successfully added to the cart").toLowerCase(), MINI_CART_ADD_TO_CART_MESSAGE.toLowerCase());
    }

    @Test
    public void s02t02() {
        driver.get(PRODUCT_URL);
        Reporter.log("Step: Navigate to the product page");
        productPage.clickLSizeButton("Step: Click the Variant Option button")
                .clickAddToCartButton("Step: Click the Add to cart button");
        miniCartPage.clickCartPageLink("Step: Navigate to the cart page");
        int valueBefore = cartPage.getSpanGrandTotalValue("Step: Register the order total value");
        cartPage.clickPlusQuantityButton("Step: Click the Plus button")
                .clickConfirmQuantityButton("Step: Click the Update button");
        Assert.assertTrue(cartPage.isGrandTotalBiggerThanValue(valueBefore, "Expected: The order total value updates based on the new quantity and product price"));
    }
}
