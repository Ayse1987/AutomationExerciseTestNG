package com.automationexercise.tests;
import com.automationexercise.utilities.ConfigReader;
import com.automationexercise.utilities.Driver;
import com.automationexercise.utilities.ReusableMethods;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
public class BaseClass {
    protected WebDriver driver;
    protected static ExtentReports extentReports;
    protected static ExtentTest extentTest;
    protected static ExtentHtmlReporter extentHtmlReporter;

    //Asagidaki gibi config readerdan getirip variable atayabilirsin istersen Test classlari clear yapabilmek icin
    String url=ConfigReader.getProperty("baseUrl");
    String name=ConfigReader.getProperty("name");

    @BeforeTest(alwaysRun = true)
    public void setUpTest() {
        //BeforeTest will run only once before all test.
        //1. create object to set the location of the report
        extentReports = new ExtentReports();
        //create a custom report in the current project.
        String filePath = System.getProperty("user.dir") + "/test-output/myprojectreport.html";
        //Folder name = test-output, File name = report.html
        //String filePath = System.getProperty("user.dir") + "\\test-output\\report.html";//THIS IS FOR WINDOWS USER
        //2. creating the report with the path we created
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        //3. attaching the html report to our custom report
        extentReports.attachReporter(extentHtmlReporter);
        //WE CAN ADD CUSTOM INFO. NOT NECESSARY. JUST TO GIVE MORE INFORMATION TO THE USER OR TEAM
        extentReports.setSystemInfo("Environment", "Environment Name");
        extentReports.setSystemInfo("Author", "Ayse");
        extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
        extentReports.setSystemInfo("Automation Engineer", "ENGINEER INFORMATION");
        extentHtmlReporter.config().setDocumentTitle("Automation Exercise Reports");
        extentHtmlReporter.config().setReportName("Automation Exercise Automation Reports");
    }
    @BeforeMethod(alwaysRun = true)
    public void setupMethod() {
        if(driver==null) {
            driver = Driver.getDriver();
        }
        //Creating Driver, and going to the application Login URL before each method

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        extentTest=extentReports.createTest("Automation Exercise extendReportsTest");
    }

    /*
    ITestResult result;
    @AfterClass(alwaysRun = true)
    public void tearDownMethod() throws IOException {


        //In AfterMethod, we are getting the screenshots and attaching the report when test fails
        //When test case fails, then take the screenshot and attached the report
        if (result.getStatus() == ITestResult.FAILURE) {
            //getScreenshot is coming from ReusableMethods
            String screenshotLocation = ReusableMethods.getScreenshot(result.getName());
            extentTest.fail(result.getName());
            //adding the screenshot in the html report
            extentTest.addScreenCaptureFromPath(screenshotLocation);
            //showing teh console error message on the html report
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.skip("Test Case is skipped: " + result.getName());
        }

    }

     */

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
    @AfterTest(alwaysRun = true)
    public void tearDownTest() {
        //Saving the report
        extentReports.flush();
    }
}
