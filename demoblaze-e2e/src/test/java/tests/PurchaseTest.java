package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class PurchaseTest extends BaseTest {

    //Purchase flow test implementing pages
    @Test
    public void purchaseFlow() {

        //Instance for every page
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        PurchasePage purchasePage = new PurchasePage(driver);

        //Definition of product we want to find out
        String product1 = "Samsung galaxy s6";
        String product2 = "Nokia lumia 1520";

        //Selecting and adding to cart first product
        homePage.selectProduct(product1);
        productPage.addToCart();
        productPage.goHomePage();

        //Selecting and adding to cart second product
        homePage.selectProduct(product2);
        productPage.addToCart();

        //Go to cart
        homePage.clickCart();

        //Validating if both products have been added to cart
        Assert.assertTrue(cartPage.isProductInCart(product1));
        Assert.assertTrue(cartPage.isProductInCart(product2));

        //Clicking "Place order" button
        cartPage.clickPlaceOrder();

        //Fill purchase info and confirming it
        purchasePage.fillForm();
        purchasePage.purchase();

        //Validating if confirmation message in sweet alert has been appeared
        Assert.assertEquals(purchasePage.confirmatioMessage(), "Thank you for your purchase!");

    }

}
