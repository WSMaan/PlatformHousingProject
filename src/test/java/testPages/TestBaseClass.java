package testPages;

import base.BaseClass;
import enums.Browsers;
import org.openqa.selenium.WebDriver;
import pages.*;
import utility.CustomerShippingInfoConfigReader;
import utility.URLconfigReader;
import utility.ValidLoginDetailsConfigReader;

public class TestBaseClass {
    protected WebDriver driver;
    protected ProductPage productPage;
    protected LoginPage loginPage;
    protected CheckoutStep1Page step1Page;
    protected CheckoutStep2Page step2Page;
    protected OrderConfirmationPage orderConfirmationPage;


    protected BaseClass baseClass = new BaseClass();

    protected void setupDriver(Browsers.browsers browser) {
        driver = baseClass.selectDriver(browser);
    }

    // Method to open the browser using the base URL
    protected void openApplication() {
        driver.get(baseURL);
    }

    // Method to close the browser using the base URL
    protected void closeApplication() {
        if (driver != null) {
            driver.quit();
        }
    }


    //read login details from config file
    protected ValidLoginDetailsConfigReader configReaderValidLogin = new ValidLoginDetailsConfigReader();
    String username = configReaderValidLogin.getUserName("user1");
    String password = configReaderValidLogin.getUserPassword("user1");


    //read customer shipping details from config file
    protected CustomerShippingInfoConfigReader configReaderShippingInfo = new CustomerShippingInfoConfigReader();
    String firstName = configReaderShippingInfo.getFirstname("user1");
    String lastName = configReaderShippingInfo.getLastName("user1");
    String zipCode = configReaderShippingInfo.getZipCode("user1");


    // Read base URL from the config file
    protected URLconfigReader urLconfigReader = new URLconfigReader();
    String baseURL = urLconfigReader.getURL("url");
}

