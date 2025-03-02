package rk._4f.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static rk._4f.pages.CartPage.CART_CODE_ADDED_MESSAGE;

public class DiscountCodeTest extends BaseTest {

    @Test
    public void s03t01() {
        Reporter.log("Scenario: Using discount codes");
        Reporter.log("Test Case: Successfully used a discount code in the cart");
        driver.get(PRODUCT_URL);
        Reporter.log("Step: Navigate to the product page");
        productPage.clickLSizeButton("Step: Click the Variant Option button")
                .clickAddToCartButton("Step: Click the Add to cart button");
        miniCartPage.clickCartPageLink("Step: Navigate to the cart page");
        int valueBefore = cartPage.getSpanGrandTotalValue("Step: Register the order total value");
        cartPage.clickCouponAccordionButton("Step: Click the 'Discount Code' button")
                .sendKeysCouponCodeInput(configFileReader.getProperty("code"), "Step: Enter a discount code to the input field")
                .clickCouponCodeButton("Step: Click 'Apply' button");
        Assert.assertTrue(cartPage.getDivToastMessageTest("Expected: The information about adding a discount code is displayed").startsWith(CART_CODE_ADDED_MESSAGE));
        Assert.assertTrue(cartPage.isGrandTotalSmallerThanValue(valueBefore, "Expected: The order total value updates based on the new quantity and product price"));
    }
}
