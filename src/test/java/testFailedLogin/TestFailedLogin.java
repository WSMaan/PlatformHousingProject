package testFailedLogin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import testPages.TestBaseClass;
import utility.InValidLoginDetailsConfigReader;

import static enums.Browsers.browsers.FIREFOX;

// Test class for failed login scenario
public class TestFailedLogin extends TestBaseClass {

    private Logger logger = LoggerFactory.getLogger(TestFailedLogin.class);

    String baseURL = "https://www.saucedemo.com/";
    InValidLoginDetailsConfigReader inValidLoginDetailsConfigReader = new InValidLoginDetailsConfigReader();


    String inValidUsername = inValidLoginDetailsConfigReader.getInValidUsername("user2");
    String inValidPassword = inValidLoginDetailsConfigReader.getInValidPassword("user2");


    @BeforeTest
    public void setUp() {

        setupDriver
                (FIREFOX);
        //(CHROME);
        //(EDGE);

        loginPage = new LoginPage(driver);
        driver.get(baseURL);
    }

    @Test
    public void testLoginWithInvalidInfo() {
        loginPage.login(inValidUsername, inValidPassword);

        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.equals(baseURL)) {
            logger.info("Login with invalid info failed, as expected");
        } else {
            logger.error("Unexpected behavior: Login succeeded with invalid info");
        }

    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
