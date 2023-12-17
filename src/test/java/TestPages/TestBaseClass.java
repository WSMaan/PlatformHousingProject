package TestPages;

import Pages.LoginPage;
import base.BaseClass;
import enums.Browsers;
import org.openqa.selenium.WebDriver;
import utility.CustomerShippingInfoConfigReader;
import utility.ValidLoginDetailsConfigReader;


public class TestBaseClass {
    protected WebDriver driver;
    protected LoginPage loginPage;

    protected BaseClass baseClass = new BaseClass();

    //read login details from config file
    protected ValidLoginDetailsConfigReader configReaderValidLogin = new ValidLoginDetailsConfigReader();
    String username = configReaderValidLogin.getUserName("user1");
    String password = configReaderValidLogin.getUserPassword("user1");

    //read customer shipping details from config file
    protected CustomerShippingInfoConfigReader configReaderShippingInfo = new CustomerShippingInfoConfigReader();

    String firstName = configReaderShippingInfo.getFirstname("user1");
    String lastName = configReaderShippingInfo.getLastName("user1");
    String zipCode = configReaderShippingInfo.getZipCode("user1");

    protected void setupDriver(Browsers.browsers browser) {
        driver = baseClass.selectDriver(browser);
    }

}

