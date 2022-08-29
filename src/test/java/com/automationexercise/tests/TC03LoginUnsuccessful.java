package com.automationexercise.tests;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.SignInPage;
import com.automationexercise.utilities.ConfigReader;
import com.automationexercise.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03LoginUnsuccessful extends BaseClass {

    HomePage homePage=new HomePage();
    SignInPage signInPage=new SignInPage();

    @Test(priority = 3, groups = "smoke")
    public void loginUnsuccessful(){
        Assert.assertTrue(homePage.logo.isDisplayed());
        homePage.signInLink.click();
        Assert.assertTrue(signInPage.loginToYourAccountExpression.isDisplayed());
        signInPage.loginEmailTextBox.sendKeys("ahmet@gmail.com");
        signInPage.loginPasswordTextBox.sendKeys("ahmet");
        signInPage.loginButton.click();
        ReusableMethods.waitFor(3);
        signInPage.yourEmailAndPasswordWrongExpression.isDisplayed();



    }

}
