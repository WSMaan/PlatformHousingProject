package testPages;

import pages.CheckoutStep1Page;
import pages.LoginPage;
import pages.ProductPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static enums.Browsers.browsers.EDGE;

public class TestCheckoutStep1Page extends TestBaseClass {
    CheckoutStep1Page step1Page;
    private Logger logger= LoggerFactory.getLogger(TestCheckoutStep1Page.class);


    @Test
    public void checkoutPage1() {
        step1Page = new CheckoutStep1Page(driver);

        step1Page.enterFirstName(firstName);
        logger.info("\"Entering first name. ");

        step1Page.enterLastName(lastName);
        logger.info("\"Entering last name. ");

        step1Page.enterZipCode(zipCode);
        logger.info("\"Entering Zip Code. ");

        step1Page.checkoutContinue();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-two.html");
    }
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }
    @BeforeClass
    public void loginBeforeProductTests() {

        setupDriver(EDGE);
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://www.saucedemo.com/");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        ProductPage productPage = new ProductPage(driver);
        productPage.selectItem1();
        productPage.selectItem2();
        productPage.viewBasket();
        productPage.checkoutButton();
    }
}

