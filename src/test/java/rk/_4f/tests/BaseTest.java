package rk._4f.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import rk._4f.helpers.ConfigFileReader;
import rk._4f.pages.*;

public class BaseTest {

    protected static final ConfigFileReader configFileReader = new ConfigFileReader("//src//test//resources//config.properties");
    protected static final String PRODUCT_URL = "https://4f.com.pl/spodnie-treningowe-szybkoschnace-meskie-czarne-4fws25tftrm0781-20s.html";

    protected WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected ProductPage productPage;
    protected MiniCartPage miniCartPage;
    protected CartPage cartPage;

    @BeforeClass
    public void setup(ITestContext ctx) {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        miniCartPage = new MiniCartPage(driver);
        cartPage = new CartPage(driver);
        driver.get(configFileReader.getProperty("baseUrl"));
        driver.manage().window().maximize();
        homePage.clickAllowCookiesButton("TESTS");
    }

    @BeforeMethod
    public void pageLoad() {


    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
