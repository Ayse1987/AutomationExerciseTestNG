package com.automationexercise.pages;

import com.automationexercise.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasesPage {
    public TestCasesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = "h2[class='title text-center']")
    public WebElement TestCasesHeader;
}
