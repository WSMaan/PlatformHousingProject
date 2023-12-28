package base;

import enums.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseClass {
    private WebDriver driver;
    private Properties properties;

    public BaseClass() {
        loadProperties();
    }

    public WebDriver selectDriver(Browsers.browsers browser) {
        String driverPath = getDriverPath(browser);

        switch (browser) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", driverPath);
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", driverPath);
                driver = new FirefoxDriver();
                break;
            case EDGE:
                System.setProperty("webdriver.edge.driver", driverPath);
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported Browser Type " + browser);
        }
        windowMaximize();

        return driver;
    }

    private void windowMaximize() {
        if (driver != null) {
            driver.manage().window().maximize();
        }
    }


    private void loadProperties() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("browsers.properties")) {
            if (input == null) {
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private String getDriverPath(Browsers.browsers browser) {
        // Assuming browser names in the properties file match the enum names.
        String browserKey = browser.toString().toLowerCase() + ".driver.path";
        return properties.getProperty(browserKey);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
