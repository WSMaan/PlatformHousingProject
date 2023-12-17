package failedLogin;

import Pages.LoginPage;
import TestPages.TestBaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utility.InValidLoginDetailsConfigReader;

import static enums.Browsers.browsers.FIREFOX;

// Test class for failed login scenario
public class TestFailedLogin extends TestBaseClass {
    InValidLoginDetailsConfigReader inValidLoginDetailsConfigReader = new InValidLoginDetailsConfigReader();
    LoginPage loginPage;

    String inValidUsername = inValidLoginDetailsConfigReader.getInValidUsername("user2");
    String inValidPassword = inValidLoginDetailsConfigReader.getInValidPassword("user2");


    @BeforeTest
    public void setUp() {

        setupDriver(FIREFOX);

        loginPage = new LoginPage(driver);
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void testLoginWithInvalidInfo() {
        loginPage.enterUsername(inValidUsername);
        loginPage.enterPassword(inValidPassword);
        loginPage.clickLoginButton();
        // Assert that the URL is the same because of a failed login
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");

    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
