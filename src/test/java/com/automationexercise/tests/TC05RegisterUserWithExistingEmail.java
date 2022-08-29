package com.automationexercise.tests;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.SignInPage;
import com.automationexercise.utilities.ConfigReader;
import com.automationexercise.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05RegisterUserWithExistingEmail extends BaseClass{

    HomePage homePage=new HomePage();
    SignInPage signInPage= new SignInPage();

    @Test
    public void registerWithExistingEmail(){
        Assert.assertTrue(homePage.logo.isDisplayed());
        homePage.signInLink.click();
        Assert.assertTrue(signInPage.newUserSignUpHeader.isDisplayed());
        signInPage.nameBox.sendKeys(ConfigReader.getProperty("name"));
        signInPage.signUpEmailTextBox.sendKeys(ConfigReader.getProperty("email"));
        signInPage.signUpButton.click();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(signInPage.emailAddressExistExpression.isDisplayed());

    }


}
