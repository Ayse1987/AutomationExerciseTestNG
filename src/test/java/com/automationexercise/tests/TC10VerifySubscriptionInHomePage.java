package com.automationexercise.tests;

import com.automationexercise.pages.HomePage;
import com.automationexercise.utilities.ConfigReader;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class TC10VerifySubscriptionInHomePage extends BaseClass {
    HomePage homePage=new HomePage();

    @Test
    public void verifySubscription(){
        Assert.assertTrue(driver.getTitle().equals(ConfigReader.getProperty("homePageTitle")));
        Actions action=new Actions(driver);
        action.moveToElement(homePage.subscriptionHeader);
        Assert.assertTrue(homePage.subscriptionHeader.isDisplayed());
        homePage.subscribeEmail.sendKeys(ConfigReader.getProperty("email"));
        homePage.subscribeArrow.click();
        Assert.assertTrue(homePage.successSubscribe.isDisplayed());
        System.out.println(homePage.successSubscribe.getText());
    }

}
