package com.automationexercise.tests;

import com.automationexercise.pages.HomePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC25VerifyScrollUpUsingArrow extends BaseClass{

    HomePage homePage=new HomePage();
    @Test
    public void arrowCheck() {
        Assert.assertTrue(homePage.logo.isDisplayed());
        //homePage.subscriptionHeader.sendKeys(Keys.ARROW_DOWN);
       Actions actions=new Actions(driver);
       actions.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).perform();
       actions.sendKeys(Keys.END).build().perform();
       Assert.assertTrue(homePage.subscriptionHeader.isDisplayed());
       actions.sendKeys(Keys.HOME).build().perform();
       //arrow nasil yukari alacagim
       Assert.assertTrue(homePage.sentenceAtTheTop.isDisplayed());




    }
}
