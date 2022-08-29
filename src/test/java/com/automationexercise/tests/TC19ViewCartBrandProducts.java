package com.automationexercise.tests;

import com.automationexercise.pages.AllProductsPage;
import com.automationexercise.pages.DressCategoryPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC19ViewCartBrandProducts extends  BaseClass{

    HomePage homePage=new HomePage();
    AllProductsPage allProductsPage=new AllProductsPage();
    DressCategoryPage dressCategoryPage=new DressCategoryPage();

    @Test
    public void viewCartBrandProduct(){
        homePage.productsLink.click();
        Assert.assertTrue(allProductsPage.brandsHeader.isDisplayed());
        allProductsPage.polo.click();
        Assert.assertTrue(driver.getCurrentUrl().equals(ConfigReader.getProperty("poloPageTitle")));
        Assert.assertTrue(dressCategoryPage.poloProductsExpression.isDisplayed());
        dressCategoryPage.hmBrandLink.click();
        Assert.assertTrue(driver.getCurrentUrl().equals(ConfigReader.getProperty("hmPageTitle")));
        Assert.assertTrue(dressCategoryPage.hmProductsExpression.isDisplayed());
    }
}
