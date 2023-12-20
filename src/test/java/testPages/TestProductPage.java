package testPages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

import static enums.Browsers.browsers.EDGE;
import static enums.Browsers.browsers.FIREFOX;

public class TestProductPage extends TestBaseClass {


    private Logger logger = LoggerFactory.getLogger(TestProductPage.class);

    @BeforeTest
    public void setUp() {
        setupDriver(EDGE);
        //(FIREFOX);
        //(CHROME);

        loginPage = new LoginPage(driver);

        openApplication();
        loginPage.login(username, password);
    }

    @Test
    public void testProductSelection() {

        productPage = new ProductPage(driver);

        productPage.select_Items_and_Checkout();


        logger.info("Added products to the basket. Viewed the basket.\n" +
                "        \"Clicked on the checkout button.\n" +
                "        \"testProductSelection completed successfully.\"");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
