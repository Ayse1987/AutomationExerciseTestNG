package com.automationexercise.tests;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.TestCasesPage;
import com.automationexercise.utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07TestCases extends BaseClass{
    HomePage homePage=new HomePage();
    TestCasesPage testCasesPage=new TestCasesPage();

    @Test
    public void testCases(){
        Assert.assertTrue(driver.getTitle().equals(ConfigReader.getProperty("homePageTitle")));
        homePage.testCasesLink.click();
        Assert.assertTrue(testCasesPage.TestCasesHeader.isDisplayed());

    }
}
