package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// In CheckoutStep1Page class  users enter personal information during checkout.
//  It provides methods to input first name, last name, zip code, and proceed to the next step
public class CheckoutStep1Page {
    private WebDriver driver;

    public CheckoutStep1Page(WebDriver driver){
        this.driver=driver;
    }
    public void enterFirstName(String firstName){
        WebElement enterFirstName=driver.findElement(By.xpath("//input[@id='first-name']"));
        enterFirstName.sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        WebElement enterLastName=driver.findElement(By.xpath("//input[@id='last-name']"));
        enterLastName.sendKeys(lastName);
    }
    public void enterZipCode(String zipCode){
        WebElement enterZipCode=driver.findElement(By.xpath("//input[@id='postal-code']"));
        enterZipCode.sendKeys(zipCode);
    }
    public void checkoutContinue(){
        WebElement checkoutContinue =driver.findElement(By.xpath("//input[@id='continue']"));
        checkoutContinue.click();
    }

}
