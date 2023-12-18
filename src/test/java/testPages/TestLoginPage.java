package testPages;

import pages.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static enums.Browsers.browsers.FIREFOX;

public class TestLoginPage extends TestBaseClass {

    private Logger logger = LoggerFactory.getLogger(TestLoginPage.class);

    @BeforeClass
    public void setUp() {
        setupDriver(FIREFOX);

        loginPage = new LoginPage(driver);
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void testLogin() {

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.equals("https://www.saucedemo.com/inventory.html")) {
            logger.info("Login successful");
        } else {
            logger.error("Login unsuccessful");
        }
    }


    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

