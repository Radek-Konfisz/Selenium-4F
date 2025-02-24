package rk._4f.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import rk._4f.pages.*;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void pageLoad(){
        driver.get("https://4f.com.pl/");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
