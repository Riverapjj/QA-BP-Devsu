package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PurchasePage extends BasePage {

    public PurchasePage(WebDriver driver) {
        super(driver);
    }

    public void fillForm() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys("Josue Rivera");
        driver.findElement(By.id("country")).sendKeys("El Salvador");
        driver.findElement(By.id("city")).sendKeys("San Salvador");
        driver.findElement(By.id("card")).sendKeys("123456789");
        driver.findElement(By.id("month")).sendKeys("01");
        driver.findElement(By.id("year")).sendKeys("2028");
    }

    public void purchase() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Purchase']"))).click();
    }

    public String confirmatioMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sweet-alert h2"))).getText();
    }
}
