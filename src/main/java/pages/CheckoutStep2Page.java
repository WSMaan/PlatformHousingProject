package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutStep2Page {
    private WebDriver driver;

    // Constructor to initialize the WebDriver
    public CheckoutStep2Page(WebDriver driver) {
        this.driver = driver;
    }

    // Method to check item prices and tax payable
    public void check_Item_Prices_and_tax_payable() {
        checkItem1(); // Check the price of Item 1
        checkItem2(); // Check the price of Item 2
        taxPayable(); // Check tax payable
        finishButton(); // Click on the Finish button
    }

    // Method to check the price of Item 1
    public double checkItem1() {

        // Locate the 1st item
        String item1Price = driver.findElement(By.xpath("//div[@class='inventory_item_price'][normalize-space()='$29.99']")).getText();
        return Double.parseDouble(item1Price.replace("$", ""));
    }

    // Method to check the price of Item 2
    public double checkItem2() {

        // Locate the 2nd item
        String item2Price = driver.findElement(By.xpath("//div[@class='inventory_item_price'][normalize-space()='$9.99']")).getText();
        return Double.parseDouble(item2Price.replace("$", ""));
    }

    // Method to check tax payable
    public String taxPayable() {

        return driver.findElement(By.xpath("//div[@class='summary_tax_label']")).getText();
    }

    // Method to click on the Finish button
    public void finishButton() {

        WebElement finishButton = driver.findElement(By.xpath("//div[@class='summary_info_label summary_total_label']"));
        finishButton.click();
    }
}
