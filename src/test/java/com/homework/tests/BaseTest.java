package com.homework.tests;

import com.homework.pages.*;
import com.homework.pages.checkout.Checkout2Page;
import com.homework.pages.checkout.CheckoutComplete;
import com.homework.pages.checkout.CheckoutPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    protected WebDriver driver;

    @BeforeMethod
    @Parameters({"WEBSITE_URL", "CHROMEDRIVER_PATH"})
    public void setUp(String WEBSITE_URL, String CHROMEDRIVER_PATH) {
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(WEBSITE_URL);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriverWait getWebDriverWait(int seconds){
        return new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    protected LoginPage getLoginPage() {
        return new LoginPage(driver);
    }

    protected InventoryPage getInventoryPage() {
        return new InventoryPage(driver);
    }

    protected CartPage getCartPage() {
        return new CartPage(driver);
    }

    protected CheckoutPage getCheckoutPage(){
        return new CheckoutPage(driver);
    }

    protected Checkout2Page getCheckout2Page(){
        return new Checkout2Page(driver);
    }

    protected CheckoutComplete getCheckoutComplete(){
        return new CheckoutComplete(driver);
    }

    protected void waitForClickable(int time, WebElement element){
        getWebDriverWait(time).until(ExpectedConditions.elementToBeClickable(element));
    }


}
