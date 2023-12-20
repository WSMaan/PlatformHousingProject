package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Page class  where users can interact with different products.
// It has methods to select items, view the shopping basket, and proceed to checkout.
public class ProductPage {
    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    //  Selects the item  by clicking the "Add to Cart" button.

    public void select_Items_and_Checkout() {
        selectItem1();
        selectItem2();
        viewBasket();
        checkoutButton();
    }

    public void selectItem1() {
        WebElement backpackLocator = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        backpackLocator.click();
    }

    //  Selects the item  by clicking the "Add to Cart" button.
    public void selectItem2() {
        WebElement lightLocator = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));
        lightLocator.click();
    }

    // Navigates to the shopping basket by clicking the "Shopping Cart" link
    public void viewBasket() {
        WebElement basketLocator = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        basketLocator.click();
    }

    // Proceeds to checkout by clicking the "Checkout" button.
    public void checkoutButton() {
        WebElement checkout = driver.findElement(By.xpath("//button[@id='checkout']"));
        checkout.click();
    }
}
