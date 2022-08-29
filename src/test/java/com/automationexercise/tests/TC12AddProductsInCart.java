package com.automationexercise.tests;

import com.automationexercise.pages.AllProductsPage;
import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.utilities.ConfigReader;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC12AddProductsInCart extends BaseClass {

    HomePage homePage = new HomePage();
    AllProductsPage allProductsPage = new AllProductsPage();
    CartPage cartPage=new CartPage();

    @Test
    public void addProductInCart() {
        Assert.assertTrue(driver.getTitle().equals(ConfigReader.getProperty("homePageTitle")));
        homePage.productsLink.click();
        Actions actions=new Actions(driver);
        actions.moveToElement(allProductsPage.firstProduct).perform();
        allProductsPage.firstProductAddToChart.click();
        allProductsPage.continueShoppingButton.click();
        actions.moveToElement(allProductsPage.secondProduct).perform();
        allProductsPage.secondProductAddToChart.click();
        allProductsPage.viewCartButton.click();
        Assert.assertTrue(cartPage.twoProductsInCart.size()==2);
        Assert.assertTrue(cartPage.firstProductPrice.getText().equals(cartPage.firstProductTotal.getText()));
        Assert.assertTrue(cartPage.firstProductQuantity.getText().equals("1"));
    }
}
