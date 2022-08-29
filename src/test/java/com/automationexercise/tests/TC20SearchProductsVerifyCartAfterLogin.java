package com.automationexercise.tests;

import com.automationexercise.pages.AllProductsPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC20SearchProductsVerifyCartAfterLogin extends BaseClass{

    HomePage homePage=new HomePage();
    AllProductsPage allProductsPage=new AllProductsPage();

    @Test
    public  void SearchProduct(){
        homePage.productsLink.click();
        Assert.assertTrue(allProductsPage.allProductsHeader.isDisplayed());
        allProductsPage.searchBox.sendKeys("top");
        allProductsPage.submitSearch.click();
        Assert.assertTrue(allProductsPage.searchedProductsExpression.isDisplayed());
        int count=0;
        for(WebElement each:allProductsPage.searchedProductList){
            if(each.getText().equalsIgnoreCase("top")){
                continue;
            }else{
                count++;
            }
        }
        if(count>0){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }

        Actions actions=new Actions(driver);

       //for(int i=0;i<=allProductsPage.searchedProductList.size()-1;i++){
       //    System.out.println(allProductsPage.searchedProductList.get(i).getText());
       //}
       for(int i=1;i<=allProductsPage.searchedProductList.size();i++){
           actions.moveToElement(allProductsPage.searchedProductList.get(i));
           allProductsPage.addAllProductsToCart.get(i-1).click();
           System.out.println(i);
           driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
           actions.doubleClick(allProductsPage.continueShoppingButton);
           ReusableMethods.waitFor(2);
       }




        
    }
}
