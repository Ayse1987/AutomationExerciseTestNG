package com.automationexercise.tests;

import com.automationexercise.pages.*;
import com.automationexercise.utilities.ConfigReader;
import com.automationexercise.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC14PlaceOrderRegisterWhileCheckout extends BaseClass{

    HomePage homePage=new HomePage();
    AllProductsPage allProductsPage=new AllProductsPage();
    CartPage cartPage=new CartPage();
    SignInPage signInPage=new SignInPage();
    CustomerHomePage customerHomePage=new CustomerHomePage();
    PaymentPage paymentPage=new PaymentPage();
    LoginFormPage loginFormPage=new LoginFormPage();
    Faker faker=new Faker();
    Select select;
    String newName;
    String email;


    @Test(groups = "end2end")
    public void placeOrderWhileCheckOut(){
        Assert.assertTrue(driver.getTitle().equals(ConfigReader.getProperty("homePageTitle")));
        homePage.productsLink.click();
        Actions actions=new Actions(driver);
        actions.moveToElement(allProductsPage.firstProduct).perform();
        allProductsPage.firstProductAddToChart.click();
        allProductsPage.continueShoppingButton.click();
        actions.moveToElement(allProductsPage.secondProduct).perform();
        allProductsPage.secondProductAddToChart.click();
        homePage.cart.click();
        Assert.assertEquals(driver.getTitle(),ConfigReader.getProperty("viewCartPageTitle"));
        cartPage.proceedToCheckOut.click();
        cartPage.registerLoginButton.click();
        newName=faker.name().toString();
        email=faker.internet().emailAddress();
        signInPage.nameBox.sendKeys(newName);
        signInPage.signUpEmailTextBox.sendKeys(email);
        signInPage.signUpButton.click();
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
        Assert.assertTrue(signInPage.accountCreatedMessage.isDisplayed());
        Assert.assertTrue(customerHomePage.loggedInExpression.isDisplayed());
        homePage.cart.click();
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
