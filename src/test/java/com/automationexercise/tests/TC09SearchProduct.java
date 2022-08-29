package com.automationexercise.tests;

import com.automationexercise.pages.AllProductsPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.utilities.ConfigReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TC09SearchProduct extends BaseClass {

    HomePage homePage = new HomePage();
    AllProductsPage allProductsPage = new AllProductsPage();

    @Test
    public void searchProduct() {
        Assert.assertTrue(driver.getTitle().equals(ConfigReader.getProperty("homePageTitle")));
        homePage.productsLink.click();
        Assert.assertTrue(allProductsPage.allProductsHeader.isDisplayed());
        allProductsPage.searchBox.sendKeys("top");
        allProductsPage.submitSearch.click();
        Assert.assertTrue(allProductsPage.searchedProductsExpression.isDisplayed());
        System.out.println(allProductsPage.searchedProductList.get(0).getText()+"===");
        int count=0;
        for(WebElement each:allProductsPage.searchedProductList) {
            if(each.getText().toLowerCase().contains("top")){
                System.out.println(each.getText());
            }else{
                count++;
                System.out.println(each.getText());
            }
            if(count>0){
                System.out.println(count);
                Assert.assertTrue(false);
            }
   }


    }
}
