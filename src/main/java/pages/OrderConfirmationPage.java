package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Page class to get order confirmation messages and logout from the application.
public class OrderConfirmationPage {
    private WebDriver driver;

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to confirm the order and get the confirmation message.
    public void confirmOrder() {
        orderConfirmationMessage();
        selectMenu();
    }

    // Method to get the order confirmation message.
    public String orderConfirmationMessage() {
        WebElement confirmationMessage = driver.findElement(By.xpath("//span[@class='title']"));
        return confirmationMessage.getText();
    }

    // Method to select the menu and wait for 5 seconds.
    public void selectMenu() {
        WebElement selectMenu = driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
        selectMenu.click();
        waitForSeconds(5);  // Wait for 5 seconds after selecting the menu.
    }

    // Method to click the logout button.
    public void logoutButton() {
        WebElement logoutButton = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
        logoutButton.click();
    }

    // Private method to implement an explicit wait for the specified number of seconds.
    private void waitForSeconds(int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
