package testPages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

import static enums.Browsers.browsers.EDGE;

public class TestLoginPage extends TestBaseClass {
    protected LoginPage loginPage;


    private Logger logger = LoggerFactory.getLogger(TestLoginPage.class);

    @BeforeTest
    public void setUp() {
        setupDriver
                (EDGE);
        // (FIREFOX);
        // (CHROME);

        loginPage = new LoginPage(driver);
        openApplication();
    }

    @Test
    public void testLogin() {

        loginPage.login(username, password);

        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.equals(baseURL + "inventory.html")) {
            logger.info("Login successful");
        } else {
            logger.error("Login unsuccessful");
        }
    }


    @AfterTest
    public void tearDown() {
        closeApplication();
    }
}

