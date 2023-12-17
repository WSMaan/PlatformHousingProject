package base;

import enums.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static enums.Browsers.browsers.*;

//The BaseClass provides a common base for initializing WebDriver instances
//  based on the specified browser type.

public class BaseClass {
    private WebDriver driver;

    public WebDriver selectDriver(Browsers.browsers browser) {
        if (CHROME.equals(browser)) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maan9\\Downloads\\chrome-win64(1)\\chrome-win64\\chrome.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        } else if (FIREFOX.equals(browser)) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Maan9\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();

        }else if (EDGE.equals(browser)){
            System.setProperty("webdriver.edge.driver","C:\\Users\\Maan9\\Downloads\\edgedriver_win64\\msedgedriver.exe");
            driver=new EdgeDriver();
            driver.manage().window().maximize();

        } else {
            throw new IllegalArgumentException(("Unsupported Browser Type " + browser));
        }
        return driver;
    }
    public WebDriver getDriver() {
        return driver;
    }
}
