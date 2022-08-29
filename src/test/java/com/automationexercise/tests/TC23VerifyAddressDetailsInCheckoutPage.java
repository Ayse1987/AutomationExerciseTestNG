package com.automationexercise.tests;

import com.automationexercise.pages.*;
import com.automationexercise.utilities.ConfigReader;
import com.automationexercise.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC23VerifyAddressDetailsInCheckoutPage extends BaseClass{


    HomePage homePage=new HomePage();
    LoginFormPage loginFormPage=new LoginFormPage();
    CustomerHomePage customerHomePage=new CustomerHomePage();
    AllProductsPage allProductsPage=new AllProductsPage();
    CartPage cartPage=new CartPage();
    PaymentPage paymentPage=new PaymentPage();
    Select select;
    Faker faker=new Faker();
    @Test
    public void verifyAddress(){
        Assert.assertTrue(driver.getTitle().equals(ConfigReader.getProperty("homePageTitle")));
        homePage.signInLink.click();
        Assert.assertTrue(homePage.newUserSignUpHeader.isDisplayed());
        homePage.nameBox.sendKeys(name);
        String email=faker.internet().emailAddress().toString();
        homePage.signUpEmailTextBox.sendKeys(email);
        homePage.signUpButton.click();
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
        ReusableMethods.waitFor(10);
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
        Actions actions=new Actions(driver);
        actions.moveToElement(allProductsPage.firstProduct).perform();
        allProductsPage.firstProductAddToChart.click();
        allProductsPage.continueShoppingButton.click();
        actions.moveToElement(allProductsPage.secondProduct).perform();
        allProductsPage.secondProductAddToChart.click();
        allProductsPage.viewCartButton.click();
        Assert.assertTrue(driver.getTitle().equals(ConfigReader.getProperty("viewCartPageTitle")));
        cartPage.proceedToCheckOut.click();
        Assert.assertTrue(paymentPage.deliveryAddress.getText().contains(ConfigReader.getProperty("address1")));
        Assert.assertTrue(paymentPage.billingAddress.getText().contains(ConfigReader.getProperty("address1")));
        Assert.assertTrue(paymentPage.deleteAccountLink.isDisplayed());

        }
}
