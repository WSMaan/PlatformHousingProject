package testPages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CheckoutStep1Page;
import pages.LoginPage;
import pages.ProductPage;

import static enums.Browsers.browsers.EDGE;

public class TestCheckoutStep1Page extends TestBaseClass {

    private Logger logger = LoggerFactory.getLogger(TestCheckoutStep1Page.class);

    @BeforeClass
    public void loginBeforeProductTests() {

        setupDriver(EDGE);
        //(FIREFOX);
        //(CHROME);

        loginPage = new LoginPage(driver);

        openApplication();
        loginPage.login(username, password);

        productPage = new ProductPage(driver);
        productPage.select_Items_and_Checkout();

    }
    @Test
    public void checkoutPage1() {
        step1Page = new CheckoutStep1Page(driver);

        step1Page.enter_Userdetails_and_Checkout(firstName,lastName,zipCode);

        logger.info("\"Entering first name. last name. and  Zip Code.  ");

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");
    }

    @AfterTest
    public void tearDown() {
       closeApplication();

    }

}

