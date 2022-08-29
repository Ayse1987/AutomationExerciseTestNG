package com.automationexercise.tests;

import com.automationexercise.pages.AllProductsPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductDetailsPage;
import com.automationexercise.utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC21AddReviewOnProduct extends BaseClass{

    HomePage homePage=new HomePage();
    AllProductsPage allProductsPage=new AllProductsPage();
    ProductDetailsPage productDetailsPage=new ProductDetailsPage();

    @Test
    public void addReview(){
        homePage.productsLink.click();
        Assert.assertTrue(allProductsPage.allProductsHeader.isDisplayed());
        allProductsPage.firstProductViewProductLink.click();
        Assert.assertTrue(productDetailsPage.writeYourReviewExpression.isDisplayed());
        productDetailsPage.name.sendKeys(ConfigReader.getProperty("name"));
        productDetailsPage.email.sendKeys(ConfigReader.getProperty("email"));
        productDetailsPage.review.sendKeys(ConfigReader.getProperty("message"));
        productDetailsPage.reviewSubmitButton.click();
        Assert.assertTrue(productDetailsPage.thankYouForReviewMessage.isDisplayed());




    }
}
