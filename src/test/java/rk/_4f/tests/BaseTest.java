package rk._4f.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import rk._4f.helpers.ConfigFileReader;
import rk._4f.pages.*;

public class BaseTest {

    public static final String PROPERTY_FILE_PATH ="//src//test//resources//config.properties";
    public static ConfigFileReader configFileReader;

    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void pageLoad(){
        configFileReader = new ConfigFileReader(PROPERTY_FILE_PATH);
        driver.get(configFileReader.getProperty("baseUrl"));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
