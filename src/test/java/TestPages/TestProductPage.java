package TestPages;

import Pages.LoginPage;
import Pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static enums.Browsers.browsers.FIREFOX;

public class TestProductPage extends TestBaseClass {

    @Test
    public void testProductSelection() {

        ProductPage productPage = new ProductPage(driver);
        productPage.selectItem1();
        productPage.selectItem2();
        productPage.viewBasket();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
        productPage.checkoutButton();
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
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

    }

}
