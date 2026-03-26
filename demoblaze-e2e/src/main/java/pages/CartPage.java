package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    //Function to validate a product has been added to cart
    public boolean isProductInCart(String productName) {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("tbodyid"), productName));
    }

    //Function to click place order button
    public void clickPlaceOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-success"))).click();
    }
}
