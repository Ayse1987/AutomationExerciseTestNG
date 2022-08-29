package com.automationexercise.tests;

import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.utilities.ConfigReader;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11VerifySubscriptionInCartPage extends BaseClass{


    @Test
    public void verifySubscriptionInCrt() {
        HomePage homePage=new HomePage();
        Actions actions=new Actions(driver);
        CartPage cartPage=new CartPage();

        Assert.assertTrue(driver.getTitle().equals(ConfigReader.getProperty("homePageTitle")));
        homePage.cart.click();
        actions.moveToElement(cartPage.subscription).perform();
        Assert.assertTrue(cartPage.subscription.isDisplayed());
        cartPage.subscribeEmail.sendKeys(ConfigReader.getProperty("email"));
        cartPage.submitSubscribeArrow.click();
        Assert.assertTrue(cartPage.successSubscriptionMessage.isDisplayed());
    }
}
