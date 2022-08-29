package com.automationexercise.tests;

import com.automationexercise.pages.*;
import com.automationexercise.utilities.ConfigReader;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC16PlaceOrderLoginBeforeCheckout extends BaseClass{
    HomePage homepage = new HomePage();
    AllProductsPage allProductsPage=new AllProductsPage();
    SignInPage signInPage = new SignInPage();
    CustomerHomePage customerHomePage = new CustomerHomePage();
    CartPage cartPage=new CartPage();
    PaymentPage paymentPage=new PaymentPage();

    @Test(groups = "end2end")
    public void placeOrderLoginBeforeCheckout(){
        Assert.assertTrue(homepage.logo.isDisplayed());
        homepage.signInLink.click();
        Assert.assertTrue(signInPage.loginToYourAccountExpression.isDisplayed());
        signInPage.loginEmailTextBox.sendKeys(ConfigReader.getProperty("email"));
        signInPage.loginPasswordTextBox.sendKeys(ConfigReader.getProperty("password"));
        signInPage.loginButton.click();
        Assert.assertTrue(customerHomePage.loggedInExpression.isDisplayed());
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
