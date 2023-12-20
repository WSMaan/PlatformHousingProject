package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CustomerShippingInfoConfigReader {
    private Properties properties;

    public CustomerShippingInfoConfigReader() {
        properties = new Properties();
        try {
            InputStream input = new FileInputStream("src/main/resources/customerShippingInfo.properties");
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFirstname(String user) {
        return properties.getProperty(user + ".firstName");
    }

    public String getLastName(String user) {
        return properties.getProperty(user + ".lastName");
    }

    public String getZipCode(String user) {
        return properties.getProperty(user + ".zipCode");
    }
}
