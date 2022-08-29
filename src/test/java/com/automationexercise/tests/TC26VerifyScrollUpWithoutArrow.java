package com.automationexercise.tests;

import com.automationexercise.pages.HomePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC26VerifyScrollUpWithoutArrow extends BaseClass {

    HomePage homePage = new HomePage();

    @Test
    public void ScrollWithoutArrowCheck() {
        Assert.assertTrue(homePage.logo.isDisplayed());
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).build().perform();
        Assert.assertTrue(homePage.subscriptionHeader.isDisplayed());
        actions.sendKeys(Keys.HOME).build().perform();
        //arrow nasil yukari alacagim
        Assert.assertTrue(homePage.sentenceAtTheTop.isDisplayed());
    }
}
