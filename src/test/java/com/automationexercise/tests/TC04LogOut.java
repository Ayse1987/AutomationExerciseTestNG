package com.automationexercise.tests;

import com.automationexercise.pages.CustomerHomePage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.SignInPage;
import com.automationexercise.utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04LogOut extends BaseClass{
    HomePage homePage=new HomePage();
    SignInPage signInPage=new SignInPage();
    CustomerHomePage customerHomePage=new CustomerHomePage();

    @Test
    public void logOut(){
        Assert.assertTrue(homePage.logo.isDisplayed());
        homePage.signInLink.click();
        Assert.assertTrue(signInPage.loginToYourAccountExpression.isDisplayed());
        signInPage.loginEmailTextBox.sendKeys(ConfigReader.getProperty("email"));
        signInPage.loginPasswordTextBox.sendKeys("password");
        signInPage.loginButton.click();
        Assert.assertTrue(customerHomePage.loggedInExpression.isDisplayed());
        customerHomePage.logOutLink.click();
        Assert.assertTrue(signInPage.loginToYourAccountExpression.isDisplayed());
    }

}
