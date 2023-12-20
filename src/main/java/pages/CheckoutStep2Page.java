package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutStep2Page {
    private WebDriver driver;

    public CheckoutStep2Page(WebDriver driver) {
        this.driver = driver;
    }
    public void check_Item_Prices_and_tax_payable(){
        checkItem1();
        checkItem2();
        taxPayable();
        finishButton();

    }

    public double checkItem1() {
        String item1Price = driver.findElement(By.xpath("//div[@class='inventory_item_price'][normalize-space()='$29.99']")).getText();
        return Double.parseDouble(item1Price.replace("$", ""));
    }

    public double checkItem2() {
        String item2Price = driver.findElement(By.xpath("//div[@class='inventory_item_price'][normalize-space()='$9.99']")).getText();
        return Double.parseDouble(item2Price.replace("$", ""));
    }

    public String taxPayable() {
        String taxPayable = driver.findElement(By.xpath("//div[@class='summary_tax_label']")).getText();
        return taxPayable;
    }

    public void finishButton() {
        WebElement finishButton = driver.findElement(By.xpath("//div[@class='summary_info_label summary_total_label']"));
        finishButton.click();
    }
}
