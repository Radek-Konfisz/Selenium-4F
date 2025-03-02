package rk._4f.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static rk._4f.pages.MiniCartPage.MINI_CART_ADD_TO_CART_MESSAGE;

public class AddToCartTest extends BaseTest {


    @Test
    public void s02t01() {
        driver.get(PRODUCT_URL); //Navigate to the product page
        productPage.clickLSizeButton() //Click the Variant Option button
                .clickAddToCartButton(); //Click the Add to cart button
        Assert.assertTrue(miniCartPage.isDisplayedDivMiniCart()); //A mini cart slides out
        Assert.assertEquals(miniCartPage.getSpanMessage().toLowerCase(), MINI_CART_ADD_TO_CART_MESSAGE.toLowerCase()); //There is an information about the product being successfully added to the cart
    }

    @Test
    public void s02t02() {
        driver.get(PRODUCT_URL); //Navigate to the product page
        productPage.clickLSizeButton() //Click the Variant Option button
                .clickAddToCartButton(); //Click the Add to cart button
        miniCartPage.clickCartPageLink(); //Navigate to the cart page
        int valueBefore = cartPage.getSpanGrandTotalValue(); //Register the order total value
        cartPage.clickPlusQuantityButton() //Click the Plus button
                .clickConfirmQuantityButton(); //Click the Update button
        Assert.assertTrue(cartPage.isGrandTotalBiggerThanValue(valueBefore)); //The order total value updates based on the new quantity and product price
    }
}
