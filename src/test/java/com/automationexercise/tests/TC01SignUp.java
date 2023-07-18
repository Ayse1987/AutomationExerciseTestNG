package com.automationexercise.tests;

import com.automationexercise.pages.CustomerHomePage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginFormPage;
import com.automationexercise.pages.SignInPage;
import com.automationexercise.utilities.ConfigReader;
import com.automationexercise.utilities.Driver;
import com.automationexercise.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01SignUp extends BaseClass {
    HomePage homepage=new HomePage();
    LoginFormPage loginFormPage =new LoginFormPage();
    SignInPage signInPage=new SignInPage();
    CustomerHomePage customerHomePage=new CustomerHomePage();
    Select select;


    @Test(priority = 2, groups = "smoke")
    public void signUpTest() {
        Faker faker=new Faker();
        Assert.assertTrue(homepage.logo.isDisplayed());
        homepage.signInLink.click();
        Assert.assertTrue(homepage.newUserSignUpHeader.isDisplayed());
        homepage.nameBox.sendKeys(name);
        homepage.signUpEmailTextBox.sendKeys(faker.internet().emailAddress());
        homepage.signUpButton.click();
        //Login form
        Assert.assertTrue(loginFormPage.loginFormPageTitle.isDisplayed());
        loginFormPage.mrRadioBtn.click();
        loginFormPage.passwordTextBox.sendKeys(ConfigReader.getProperty("password"));
        select=new Select(loginFormPage.dayDropdown);
        select.selectByValue("1");
        select=new Select(loginFormPage.monthsDropdown);
        select.selectByValue("2");
        select=new Select(loginFormPage.yearDropdown);
        select.selectByValue("2000");
        loginFormPage.newsletterCheckBox.click();
        loginFormPage.specialOfferCheckBox.click();
        loginFormPage.firstNameTexBox.sendKeys(ConfigReader.getProperty("name"));
        loginFormPage.lastNameTexBox.sendKeys(ConfigReader.getProperty("lastName"));
        loginFormPage.companyTexBox.sendKeys(ConfigReader.getProperty("company"));
        loginFormPage.address1TexBox.sendKeys(ConfigReader.getProperty("address1"));
        loginFormPage.address2TexBox.sendKeys(ConfigReader.getProperty("address2"));
        select=new Select(loginFormPage.countryDropDown);
        select.selectByValue(ConfigReader.getProperty("country"));
        loginFormPage.stateTextBox.sendKeys(ConfigReader.getProperty("state"));
        loginFormPage.cityTextBox.sendKeys(ConfigReader.getProperty("city"));
        loginFormPage.zipcodeTextBox.sendKeys("zipcode");
        loginFormPage.mobileNumberTextBox.sendKeys(ConfigReader.getProperty("mobileNumber"));
        loginFormPage.createAccountButton.click();
        loginFormPage.accountCreatedMessage.isDisplayed();
        loginFormPage.continueButton.click();
        customerHomePage.loggedInExpression.isDisplayed();
        customerHomePage.deleteAccountLink.click();



    }

}
