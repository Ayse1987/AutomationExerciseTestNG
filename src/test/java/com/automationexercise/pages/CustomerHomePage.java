package com.automationexercise.pages;

import com.automationexercise.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerHomePage {

    public CustomerHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//i[@class='fa fa-user']")
    public WebElement loggedInExpression;

    @FindBy (xpath = "//a[@href='/delete_account']")
    public WebElement deleteAccountLink;

    @FindBy(css = "a[href='/logout']")
    public WebElement logOutLink;
}
