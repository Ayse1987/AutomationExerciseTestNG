package com.automationexercise.tests;

import com.automationexercise.pages.*;
import com.automationexercise.utilities.ConfigReader;
import com.automationexercise.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC17RemoveProductsFromCart extends  BaseClass{

    HomePage homePage=new HomePage();
    SignInPage signInPage= new SignInPage();
    CartPage cartPage=new CartPage();
    CustomerHomePage customerHomePage=new CustomerHomePage();
    AllProductsPage allProductsPage=new AllProductsPage();

   @Test
   public void removeProductFromCart(){
       Assert.assertTrue(homePage.logo.isDisplayed());
       homePage.signInLink.click();
       Assert.assertTrue(signInPage.loginToYourAccountExpression.isDisplayed());
       signInPage.loginEmailTextBox.sendKeys(ConfigReader.getProperty("email"));
       signInPage.loginPasswordTextBox.sendKeys(ConfigReader.getProperty("password"));
       signInPage.loginButton.click();
       Assert.assertTrue(customerHomePage.loggedInExpression.isDisplayed());
       homePage.productsLink.click();
       Actions actions=new Actions(driver);
       actions.moveToElement(allProductsPage.firstProduct).perform();
       allProductsPage.firstProductAddToChart.click();
       allProductsPage.continueShoppingButton.click();
       actions.moveToElement(allProductsPage.secondProduct).perform();
       allProductsPage.secondProductAddToChart.click();
       homePage.cart.click();
       Assert.assertEquals(driver.getTitle(),ConfigReader.getProperty("viewCartPageTitle"));
       WebElement firstProduct= driver.findElement(By.id("product-2"));
       cartPage.deleteFirstProduct.click();
       ReusableMethods.waitFor(3);
       try {
           Assert.assertFalse(firstProduct.isDisplayed());
       }catch (StaleElementReferenceException e){
           Assert.assertTrue(true);
       }


   }
}
