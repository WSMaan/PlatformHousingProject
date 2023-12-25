package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Page class  where users can interact with different products.
// It has methods to select items, view the shopping basket, and proceed to checkout.
public class ProductPage {
    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //  Selects the item  by clicking the "Add to Cart" button.

    public void select_Items_and_Checkout() {
        selectItem1();
        selectItem2();
        viewBasket();
        checkoutButton();
    }

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement backpackLocator;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
    private WebElement lightLocator;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement basketLocator;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkout;


    private void selectItem1() {
        backpackLocator.click();
    }

    //  Selects the item  by clicking the "Add to Cart" button.
    private void selectItem2() {
        lightLocator.click();
    }

    // Navigates to the shopping basket by clicking the "Shopping Cart" link
    private void viewBasket() {
        basketLocator.click();
    }

    // Proceeds to checkout by clicking the "Checkout" button.
    private void checkoutButton() {
        checkout.click();
    }
}
