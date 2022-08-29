package com.automationexercise.tests;

import com.automationexercise.pages.AllProductsPage;
import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductDetailsPage;
import com.automationexercise.utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC13VerifyProductQuantityInCart extends BaseClass{

    HomePage homePage=new HomePage();
    AllProductsPage allProductsPage=new AllProductsPage();
    ProductDetailsPage productDetailsPage=new ProductDetailsPage();
    CartPage cartPage=new CartPage();

@Test
    public void verifyProductQuantityInCart(){
    Assert.assertTrue(driver.getTitle().equals(ConfigReader.getProperty("homePageTitle")));
    homePage.productsLink.click();
    allProductsPage.firstProductViewProductLink.click();
    Assert.assertTrue(driver.getTitle().equals(ConfigReader.getProperty("productDetailPageTitle")));
    productDetailsPage.quantity.clear();
    productDetailsPage.quantity.sendKeys("4");
    productDetailsPage.addToCart.click();
    productDetailsPage.viewCart.click();
    Assert.assertTrue(cartPage.firstProductInCart.isDisplayed());
    Assert.assertTrue(cartPage.firstProductQuantity.getText().equals("4"));

}

}
