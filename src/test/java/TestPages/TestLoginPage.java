package TestPages;

import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static enums.Browsers.browsers.FIREFOX;

public class TestLoginPage extends TestBaseClass {

    @BeforeTest
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
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }


    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

