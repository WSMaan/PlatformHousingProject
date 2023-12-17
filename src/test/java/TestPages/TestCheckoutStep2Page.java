package TestPages;

import Pages.CheckoutStep1Page;
import Pages.CheckoutStep2Page;
import Pages.LoginPage;
import Pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static enums.Browsers.browsers.FIREFOX;

public class TestCheckoutStep2Page extends TestBaseClass {
    CheckoutStep2Page step2Page;

    @Test
    public void testStep2Page() {
        step2Page = new CheckoutStep2Page(driver);

        String actualItem1Price = step2Page.checkItem1("Sauce Labs Backpack");
        Assert.assertEquals(actualItem1Price, "$29.99", "Item 1 price is not as expected");


        String actualItem2Price = step2Page.checkItem2("Sauce Labs Bike Light");
        Assert.assertEquals(actualItem2Price, "$9.99", "Item 2 price is not as expected");

        step2Page.finishButton();
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

        setupDriver(FIREFOX);
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
        CheckoutStep1Page step1Page = new CheckoutStep1Page(driver);
        step1Page.enterFirstName("Abc");
        step1Page.enterLastName("xyz");
        step1Page.enterZipCode("123");
        step1Page.checkoutContinue();
    }

}



