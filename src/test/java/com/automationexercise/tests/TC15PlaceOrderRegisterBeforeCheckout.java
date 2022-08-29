package com.automationexercise.tests;

import com.automationexercise.pages.*;
import com.automationexercise.utilities.ConfigReader;
import com.automationexercise.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC15PlaceOrderRegisterBeforeCheckout extends BaseClass {
    HomePage homepage = new HomePage();
    LoginFormPage loginFormPage = new LoginFormPage();
    AllProductsPage allProductsPage=new AllProductsPage();
    SignInPage signInPage = new SignInPage();
    CustomerHomePage customerHomePage = new CustomerHomePage();
    CartPage cartPage=new CartPage();
    PaymentPage paymentPage=new PaymentPage();
    Select select;
    Faker faker=new Faker();
    String email;
    String name;


    @Test(groups = "end2end")
    public void placeOrderBeforeCheckout() {
        Assert.assertTrue(homepage.logo.isDisplayed());
        homepage.signInLink.click();
        Assert.assertTrue(homepage.newUserSignUpHeader.isDisplayed());
        name=faker.name().toString();
        email=faker.internet().emailAddress();
        homepage.nameBox.sendKeys(name);
        homepage.signUpEmailTextBox.sendKeys(email);
        homepage.signUpButton.click();
        //Login form
        Assert.assertTrue(loginFormPage.loginFormPageTitle.isDisplayed());
        loginFormPage.mrRadioBtn.click();
        loginFormPage.passwordTextBox.sendKeys(ConfigReader.getProperty("password"));
        select = new Select(loginFormPage.dayDropdown);
        select.selectByValue("1");
        select = new Select(loginFormPage.monthsDropdown);
        select.selectByValue("2");
        select = new Select(loginFormPage.yearDropdown);
        select.selectByValue("2000");
        loginFormPage.newsletterCheckBox.click();
        loginFormPage.specialOfferCheckBox.click();
        ReusableMethods.waitFor(10);
        loginFormPage.firstNameTexBox.sendKeys(ConfigReader.getProperty("name"));
        loginFormPage.lastNameTexBox.sendKeys(ConfigReader.getProperty("lastName"));
        loginFormPage.companyTexBox.sendKeys(ConfigReader.getProperty("company"));
        loginFormPage.address1TexBox.sendKeys(ConfigReader.getProperty("address1"));
        loginFormPage.address2TexBox.sendKeys(ConfigReader.getProperty("address2"));
        select = new Select(loginFormPage.countryDropDown);
        select.selectByValue(ConfigReader.getProperty("country"));
        loginFormPage.stateTextBox.sendKeys(ConfigReader.getProperty("state"));
        loginFormPage.cityTextBox.sendKeys(ConfigReader.getProperty("city"));
        loginFormPage.zipcodeTextBox.sendKeys("zipcode");
        loginFormPage.mobileNumberTextBox.sendKeys(ConfigReader.getProperty("mobileNumber"));
        loginFormPage.createAccountButton.click();
        loginFormPage.accountCreatedMessage.isDisplayed();
        loginFormPage.continueButton.click();
        customerHomePage.loggedInExpression.isDisplayed();
        homepage.productsLink.click();
        Actions actions=new Actions(driver);
        actions.moveToElement(allProductsPage.firstProduct).perform();
        allProductsPage.firstProductAddToChart.click();
        allProductsPage.continueShoppingButton.click();
        actions.moveToElement(allProductsPage.secondProduct).perform();
        allProductsPage.secondProductAddToChart.click();
        homepage.cart.click();
        Assert.assertEquals(driver.getTitle(),ConfigReader.getProperty("viewCartPageTitle"));
        cartPage.proceedToCheckOut.click();
        Assert.assertTrue(cartPage.addressDetails.isDisplayed()&cartPage.reviewYourOrder.isDisplayed());
        cartPage.description.sendKeys("description");
        cartPage.placeOrderButton.click();
        paymentPage.nameOnTheCard.sendKeys("ali");
        paymentPage.cardNumber.sendKeys("123");
        paymentPage.cvc.sendKeys("123");
        paymentPage.expiryMonth.sendKeys("January");
        paymentPage.expiryYear.sendKeys("2023");
        paymentPage.payAndConfirmOrder.click();
        paymentPage.continueButton.click();
    }
}