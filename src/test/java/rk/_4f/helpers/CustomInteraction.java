package rk._4f.helpers;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class CustomInteraction {

    private static final Logger logger = LoggerFactory.getLogger(CustomInteraction.class);
    private static final Duration DEFAULT_DURATION = Duration.ofSeconds(2);

    public static void customClick(WebDriver driver, WebElement element) {
        customExplicitWait(driver, element);
        element.click();
    }


    public static void customSendKeys(WebDriver driver, WebElement element, String text) {
        customExplicitWait(driver, element);
        element.sendKeys(text);
    }

    public static Boolean customIsDisplayed(WebDriver driver, WebElement element) {
        try {
            customExplicitWait(driver, element);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static String customGetText(WebDriver driver, WebElement element) {
        customExplicitWait(driver, element);
        return element.getText();
    }

    public static void customImplicitlyWait(WebDriver driver, long duration) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
    }

    public static void customExplicitWait(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_DURATION);
        wait.until(d -> element.isDisplayed());
    }

    public static void customExplicitWait(WebDriver driver, WebElement element, long duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(d -> element.isDisplayed());
    }

    public static Boolean isBiggerThanValue(WebDriver driver, WebElement element, int value) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, DEFAULT_DURATION);
            wait.until(d -> Integer.parseInt(customGetText(d,element)) > value);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

}
