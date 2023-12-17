package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//In  CheckoutStep2Page class  users can check item prices, tax payable, and complete the checkout.
// * It provides methods to check the price of items, tax payable, and click the finish button.

public class CheckoutStep2Page {
    private WebDriver driver;

    public CheckoutStep2Page(WebDriver driver) {
        this.driver = driver;
    }

    public String checkItem1(String item) {
        String item1Price = driver.findElement(By.xpath("//div[@class='inventory_item_price'][normalize-space()='$29.99']")).getText();
        return item1Price;
    }

    public String checkItem2(String item) {
        String item2Price = driver.findElement(By.xpath("//div[@class='inventory_item_price'][normalize-space()='$9.99']")).getText();
        return item2Price;
    }

    public String taxPayable() {
        String taxPayable = driver.findElement(By.xpath("//div[@class='summary_tax_label']")).getText();
        return taxPayable;

    }
    public void finishButton(){
        WebElement finishButton=driver.findElement(By.xpath("//div[@class='summary_info_label summary_total_label']"));
        finishButton.click();
    }
}