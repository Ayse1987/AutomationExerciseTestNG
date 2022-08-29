package com.automationexercise.tests;

import com.automationexercise.pages.DressCategoryPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.utilities.ConfigReader;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC18ViewCategoryProducts extends BaseClass {
    HomePage homePage=new HomePage();
    DressCategoryPage dressCategoryPage=new DressCategoryPage();

    @Test
    public void viewCategories(){
        Assert.assertTrue(homePage.category.isDisplayed());
        Actions actions=new Actions(driver);
        actions.moveToElement(homePage.womanCategory).click();
        actions.moveToElement(homePage.dressCategory).click();
        Assert.assertTrue(dressCategoryPage.womanDressProducts.isDisplayed());
        dressCategoryPage.menCategory.click();
        dressCategoryPage.tShirtCategory.click();
        Assert.assertTrue(dressCategoryPage.menTshirtProducts.isDisplayed());
    }
}
