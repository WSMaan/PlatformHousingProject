package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ValidLoginDetailsConfigReader {
    private Properties properties;

    public ValidLoginDetailsConfigReader() {
        properties = new Properties();
        try (InputStream input = new FileInputStream("src/main/resources/validLogindetails.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getUserName(String user){
        return properties.getProperty(user + ".username");
    }
    public String getUserPassword(String user){
        return properties.getProperty(user + ".password");
    }
}
