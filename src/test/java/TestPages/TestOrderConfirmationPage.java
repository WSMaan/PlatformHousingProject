package TestPages;

import Pages.*;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static enums.Browsers.browsers.FIREFOX;

public class TestOrderConfirmationPage extends TestBaseClass {
    OrderConfirmationPage orderConfirmationPage;


    @Test
    public void confirmOrder() {
        orderConfirmationPage = new OrderConfirmationPage(driver);

        orderConfirmationPage.orderConfirmationMessage();

        orderConfirmationPage.selectMenu();

        orderConfirmationPage.logoutButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }

    @AfterTest
    public void tearDown(){
        if (driver !=null){
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

        CheckoutStep2Page step2Page = new CheckoutStep2Page(driver);
        String actualItem1Price = step2Page.checkItem1("Sauce Labs Backpack");
        String actualItem2Price = step2Page.checkItem2("Sauce Labs Bike Light");
        step2Page.finishButton();

    }

}
