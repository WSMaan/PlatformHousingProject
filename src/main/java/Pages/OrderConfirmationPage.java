package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Page class to get confirmation messages, navigate to the menu, and logout from the application.
public class OrderConfirmationPage {
    private WebDriver driver;

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void orderConfirmationMessage() {
        WebElement confirmationMessage = driver.findElement(By.xpath("//span[@class='title']"));

        String messageText = confirmationMessage.getText();

    }

    public void selectMenu() {
        WebElement selectMenu = driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
        selectMenu.click();
        waitForSeconds(3);
    }

    public void logoutButton() {
        WebElement logoutButton = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
        logoutButton.click();


    }

    private void waitForSeconds(int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
