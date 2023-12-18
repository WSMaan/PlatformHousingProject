package testPages;

import pages.LoginPage;
import pages.ProductPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static enums.Browsers.browsers.FIREFOX;

public class TestProductPage extends TestBaseClass {
    private Logger logger = LoggerFactory.getLogger(TestProductPage.class);

    @Test
    public void testProductSelection() {

        ProductPage productPage = new ProductPage(driver);
        productPage.selectItem1();
        productPage.selectItem2();
        logger.info("Added products to the basket. ");

        productPage.viewBasket();
        logger.info("Viewed the basket.");

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/cart.html";
        Assert.assertEquals(currentUrl, expectedUrl, "Actual URL: " + currentUrl + " is not equal to expected URL: " + expectedUrl);

        productPage.checkoutButton();
        logger.info("Clicked on the checkout button.");

        logger.info("testProductSelection completed successfully.");
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
    }

}
