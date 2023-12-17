package TestPages;

import Pages.CheckoutStep1Page;
import Pages.LoginPage;
import Pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static enums.Browsers.browsers.EDGE;

public class TestCheckoutStep1Page extends TestBaseClass {
    CheckoutStep1Page step1Page;


    @Test
    public void checkoutPage1() {
        step1Page = new CheckoutStep1Page(driver);

        step1Page.enterFirstName(firstName);
        step1Page.enterLastName(lastName);
        step1Page.enterZipCode(zipCode);
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

