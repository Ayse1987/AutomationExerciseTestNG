package com.automationexercise.tests;

import com.automationexercise.pages.AllProductsPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC08VerifyAllProducts extends BaseClass {

    HomePage homePage=new HomePage();
    AllProductsPage allProductsPage=new AllProductsPage();

    @Test
    public void verifyAllProducts(){
        Assert.assertTrue(driver.getTitle().equals(ConfigReader.getProperty("homePageTitle")));
        homePage.productsLink.click();
        Assert.assertTrue(allProductsPage.allProductsHeader.isDisplayed());
        allProductsPage.firstProductViewProductLink.click();
        Assert.assertTrue(driver.getTitle().equals(ConfigReader.getProperty("productDetailPageTitle")));
        Assert.assertTrue(allProductsPage.productName.isDisplayed());
        Assert.assertTrue(allProductsPage.categoryOfProduct.isDisplayed());
        Assert.assertTrue(allProductsPage.price.isDisplayed());
        Assert.assertTrue(allProductsPage.availibility.isDisplayed());
        Assert.assertTrue(allProductsPage.condition.isDisplayed());
        Assert.assertTrue(allProductsPage.brand.isDisplayed());


    }
}
