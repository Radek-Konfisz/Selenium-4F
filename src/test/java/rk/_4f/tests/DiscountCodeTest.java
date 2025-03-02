package rk._4f.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static rk._4f.pages.CartPage.CART_CODE_ADDED_MESSAGE;

public class DiscountCodeTest extends BaseTest {

    @Test
    public void s03t01() {
        driver.get(PRODUCT_URL); //Navigate to the product page
        productPage.clickLSizeButton() //Click the Variant Option button
                .clickAddToCartButton(); //Click the Add to cart button
        miniCartPage.clickCartPageLink(); //Navigate to the cart page
        int valueBefore = cartPage.getSpanGrandTotalValue(); //Register the order total value
        cartPage.clickCouponAccordionButton() //Click the 'Discount Code' button
                .sendKeysCouponCodeInput(configFileReader.getProperty("code")) //Enter a discount code to the input field
                .clickCouponCodeButton(); //Click 'Apply' button
        Assert.assertTrue(cartPage.getDivToastMessageTest().startsWith(CART_CODE_ADDED_MESSAGE)); //The information about adding a discount code is displayed
        Assert.assertTrue(cartPage.isGrandTotalSmallerThanValue(valueBefore)); //The order total value updates based on the new quantity and product price
    }
}
