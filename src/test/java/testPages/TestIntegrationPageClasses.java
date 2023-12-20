package testPages;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.*;

import static enums.Browsers.browsers.EDGE;

// Test class for integration testing of all page classes

//• logs in, adds 2 item(s) to the basket, proceeds to checkout and checks out successfully
public class TestIntegrationPageClasses extends TestBaseClass {
    OrderConfirmationPage orderConfirmationPage;

    @Test
    public void integrationTest() {
        setupDriver(EDGE);
        //(FIREFOX);
        //(CHROME);


        loginPage = new LoginPage(driver);

        openApplication();
        loginPage.login(username, password);

        productPage = new ProductPage(driver);
        productPage.select_Items_and_Checkout();

        step1Page = new CheckoutStep1Page(driver);
        step1Page.enter_Userdetails_and_Checkout(firstName, lastName, zipCode);

        step2Page = new CheckoutStep2Page(driver);
        step2Page.check_Item_Prices_and_tax_payable();

        orderConfirmationPage = new OrderConfirmationPage(driver);

        orderConfirmationPage.confirmOrder();
        orderConfirmationPage.logoutButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");

    }

    @AfterTest
    public void tearDown() {
        closeApplication();
    }
}
