package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Function to select products by name
    public void selectProduct(String productName) {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(productName))).click();
    }

    //Function to click cart element
    public void clickCart() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("cartur"))).click();
    }
}
