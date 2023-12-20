package testPages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import static enums.Browsers.browsers.EDGE;

public class TestOrderConfirmationPage extends TestBaseClass {

    private Logger logger = LoggerFactory.getLogger(TestOrderConfirmationPage.class);

    @BeforeTest
    public void loginBeforeProductTests() {

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
    }

    @Test
    public void confirmOrder_and_logout() {
        orderConfirmationPage = new OrderConfirmationPage(driver);

        orderConfirmationPage.confirmOrder();
        String messageText = orderConfirmationPage.orderConfirmationMessage();
        logger.info("Verify the order confirmation text. " + messageText);

        orderConfirmationPage.logoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        logger.info("Logout Successful");
    }

    @AfterTest
    public void tearDown() {
        closeApplication();
    }
}
