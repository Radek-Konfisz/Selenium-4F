package rk._4f.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import rk._4f.pages.CartPage;
import rk._4f.pages.MiniCartPage;
import rk._4f.pages.ProductPage;

import java.time.Duration;

import static rk._4f.pages.MiniCartPage.MINI_CART_ADD_TO_CART_MESSAGE;

public class AddToCartTest extends BaseTest {

    static final String PRODUCT_URL = "https://4f.com.pl/spodnie-treningowe-szybkoschnace-meskie-czarne-4fws25tftrm0781-20s.html";

    @Test
    public void s02t01() {
        productPage = new ProductPage(driver);
        miniCartPage = new MiniCartPage(driver);

        driver.get(PRODUCT_URL);
        productPage.clickLSizeButton()
                .clickAddToCartButton();
        Assert.assertTrue(miniCartPage.isDisplayedDivMiniCart());
        Assert.assertEquals(miniCartPage.getSpanMessage().toLowerCase(), MINI_CART_ADD_TO_CART_MESSAGE.toLowerCase());
    }

    @Test
    public void s02t02() {
        productPage = new ProductPage(driver);
        miniCartPage = new MiniCartPage(driver);
        cartPage = new CartPage(driver);

        driver.get(PRODUCT_URL);
        productPage.clickLSizeButton()
                .clickAddToCartButton();
        miniCartPage.clickCartPageLink();
        int valueBefore = Integer.parseInt(cartPage.getSpanGrandTotal());
        cartPage.clickPlusQuantityButton()
                .clickConfirmQuantityButton();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply(WebDriver d) {
//                return Integer.parseInt(cartPage.getSpanGrandTotal()) > valueBefore;
//            }
//        });

        wait.until(d -> Integer.parseInt(cartPage.getSpanGrandTotal()) > valueBefore);
        Assert.assertTrue(true);
    }
}
