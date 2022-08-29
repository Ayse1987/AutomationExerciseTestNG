package com.automationexercise.tests;

import com.automationexercise.data.Path;
import com.automationexercise.pages.ContactUsPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.utilities.ConfigReader;
import com.automationexercise.utilities.Driver;
import com.automationexercise.utilities.ReusableMethods;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06ContuctUs extends BaseClass{

    HomePage homePage=new HomePage();
    ContactUsPage contactUsPage=new ContactUsPage();

    @Test
    public void contactUs(){
        Assert.assertTrue(Driver.getDriver().getTitle().equals(ConfigReader.getProperty("homePageTitle")));
        homePage.contactUsLink.click();
        Assert.assertTrue(contactUsPage.getInTouchExpression.isDisplayed());
        contactUsPage.nameTextBox.sendKeys(ConfigReader.getProperty("name"));
        contactUsPage.emailTextBox.sendKeys(ConfigReader.getProperty("email"));
        contactUsPage.subjectTextBox.sendKeys(ConfigReader.getProperty("subject"));
        contactUsPage.messageTextBox.sendKeys(ConfigReader.getProperty("message"));
        contactUsPage.uploadFile.sendKeys(Path.filePath);
        contactUsPage.submitButton.click();
        ReusableMethods.waitFor(3);
        driver.switchTo().alert().accept();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(contactUsPage.successMessage.isDisplayed());
        contactUsPage.homePageLink.click();
        Assert.assertTrue(Driver.getDriver().getTitle().equals(ConfigReader.getProperty("homePageTitle")));

        driver.quit();
    }
}
