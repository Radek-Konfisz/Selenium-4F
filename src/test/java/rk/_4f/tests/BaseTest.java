package rk._4f.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import rk._4f.helpers.ConfigFileReader;
import rk._4f.pages.*;

public class BaseTest {

    public static final ConfigFileReader configFileReader = new ConfigFileReader("//src//test//resources//config.properties");

    protected WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected ProductPage productPage;
    protected MiniCartPage miniCartPage;
    protected CartPage cartPage;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.get(configFileReader.getProperty("baseUrl"));
        driver.manage().window().maximize();
        homePage.clickAllowCookiesButton();
    }

    @BeforeMethod
    public void pageLoad(){
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
