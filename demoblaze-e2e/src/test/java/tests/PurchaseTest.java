package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class PurchaseTest extends BaseTest {

    @Test
    public void purchaseFlow() {

        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        PurchasePage purchasePage = new PurchasePage(driver);

        String product1 = "Samsung galaxy s6";
        String product2 = "Nokia lumia 1520";

        homePage.selectProduct(product1);
        productPage.addToCart();
        productPage.goHomePage();

        homePage.selectProduct(product2);
        productPage.addToCart();

        homePage.clickCart();

        Assert.assertTrue(cartPage.isProductInCart(product1));
        Assert.assertTrue(cartPage.isProductInCart(product2));

        cartPage.clickPlaceOrder();
        purchasePage.fillForm();
        purchasePage.purchase();

        Assert.assertEquals(purchasePage.confirmatioMessage(), "Thank you for your purchase!");

    }

}
