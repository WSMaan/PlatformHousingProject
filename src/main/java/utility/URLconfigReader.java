package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class URLconfigReader {
    private Properties properties;

    public URLconfigReader() {
        properties = new Properties();

        try {
            InputStream input = new FileInputStream("src/main/resources/URLconfig.properties");
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getURL(String url) {
        return properties.getProperty(url + ".baseUrl");
    }

}
