package com.automationexercise.tests;

import com.automationexercise.pages.AllProductsPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC22AddToCartFromRecommendedItems extends BaseClass{

    HomePage homePage=new HomePage();
    AllProductsPage allProductsPage=new AllProductsPage();

    @Test
    public void addFromRecommendedProducts(){
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END);
        ReusableMethods.waitFor(3);
        Assert.assertTrue(homePage.recommendedItemsHeader.isDisplayed());
        homePage.firstRecommentedProductAddToCartButton.click();
        ReusableMethods.waitFor(2);
        homePage.viewCartLink.click();
        Assert.assertTrue(homePage.firstRecommendedProduct.isDisplayed());





    }
}
