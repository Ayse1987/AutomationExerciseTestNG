package com.automationexercise.tests;

import com.automationexercise.pages.CustomerHomePage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.SignInPage;
import com.automationexercise.utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02LoginSuccessful extends BaseClass{

    HomePage homePage=new HomePage();
    SignInPage signInPage=new SignInPage();
    CustomerHomePage customerHomePage=new CustomerHomePage();

    @Test(priority = 1 , groups = "smoke")
    public void loginSuccessful(){
        Assert.assertTrue(homePage.logo.isDisplayed());
        homePage.signInLink.click();
        Assert.assertTrue(signInPage.loginToYourAccountExpression.isDisplayed());
        signInPage.loginEmailTextBox.sendKeys(ConfigReader.getProperty("email"));
        signInPage.loginPasswordTextBox.sendKeys(ConfigReader.getProperty("password"));
        signInPage.loginButton.click();
        Assert.assertTrue(customerHomePage.loggedInExpression.isDisplayed());
        customerHomePage.deleteAccountLink.isDisplayed();





    }

}
