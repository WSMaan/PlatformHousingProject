package testPages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CheckoutStep1Page;
import pages.CheckoutStep2Page;
import pages.LoginPage;
import pages.ProductPage;

import static enums.Browsers.browsers.EDGE;
import static enums.Browsers.browsers.FIREFOX;

public class TestCheckoutStep2Page extends TestBaseClass {

    private Logger logger = LoggerFactory.getLogger(TestCheckoutStep2Page.class);

    @BeforeTest
    public void login_Before_ProductTests()  {

        setupDriver(EDGE);
        //(FIREFOX);
        //(CHROME);


        loginPage = new LoginPage(driver);

        openApplication();
        loginPage.login(username,password);

        productPage = new ProductPage(driver);
        productPage.select_Items_and_Checkout();

        step1Page = new CheckoutStep1Page(driver);
        step1Page.enter_Userdetails_and_Checkout(firstName, lastName, zipCode);
    }

    @Test
    public void testStep2Page() {
        step2Page = new CheckoutStep2Page(driver);

        double actualItem1Price = step2Page.checkItem1();
        Assert.assertEquals(actualItem1Price, 29.99, "Item 1 price is not as expected");

        double actualItem2Price = step2Page.checkItem2();
        Assert.assertEquals(actualItem2Price, 9.99, "Item 2 price is not as expected");

        // Calculate the total
        double total = actualItem1Price + actualItem2Price;
        logger.info("Calculated the total price of items in the basket. ");

        step2Page.check_Item_Prices_and_tax_payable();



        // Assert the total value
        Assert.assertEquals(total, expectedTotal, "Total price calculation is incorrect");
    }

    // Add your expectedTotal value here
    private double expectedTotal = 39.98;

    @AfterTest
    public void tearDown() {
       closeApplication();
    }

}



