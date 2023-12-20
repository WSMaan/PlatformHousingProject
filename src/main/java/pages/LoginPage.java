package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Page object for the login functionality
public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to perform login with provided credentials
    public void login(String username, String password) {
        setUsername(username); // Set the username
        setPassword(password); // Set the password
        clickLoginButton();    // Click the login button
    }

    public void setUsername(String username) {
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='user-name']"));
        usernameField.sendKeys(username);
    }


    public void setPassword(String password) {
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys(password);
    }


    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
    }
}
