package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class InValidLoginDetailsConfigReader {
    private Properties properties;

    public InValidLoginDetailsConfigReader(){
        properties = new Properties();
        try {
            InputStream input = new FileInputStream("src/main/resources/InvalidLoginDetails.properties");
            properties.load(input);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public String getInValidUsername(String user){
        return  properties.getProperty(user + ".username");
    }
    public String getInValidPassword(String user){
        return properties.getProperty(user + ".password");
    }

}
