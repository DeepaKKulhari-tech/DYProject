package com.axis360.generics;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**
 * @author  Deepak Yadav , @Mail ydeepkcs@gmail.com
 * **/

public class BaseLib {

    // declare WebDriver
    public WebDriver driver;
//    private ExtentReports report;
//    private ExtentTest test;

    // BeforeMethod testng annotation
    // to initialize browser and navigate browser to desired link
    @BeforeMethod
    @Parameters("browser") // parameter name "browser"
    public void setUp(String browserName) {

        // Launch browser based on the browserName
        // passed as an argument
        if(browserName.equalsIgnoreCase("chrome")) {
            // set key and value
            // for system property
            System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
            // instantiate
            // and up casting Chromedriver to Webdriver
            driver = new ChromeDriver();
            //Report successful launch
            Reporter.log("XXXXXXXXXX--- Chrome Browser Launched Successfully ! ---XXXXXXXXXX", true);

        } else if(browserName.equalsIgnoreCase("firefox")) {
            // set key and value
            // for system property
            System.setProperty("webdriver.gecko.driver", "./exefiles/geckodriver.exe");
            // instantiate
            // and up casting Firefoxdriver to Webdriver
            driver = new FirefoxDriver();
            //Report successful launch
            Reporter.log("XXXXXXXXXX--- Firefox Browser Launched Successfully ! ---XXXXXXXXXX", true);

        } else {
            // set key and value
            // for system property
            System.setProperty("webdriver.edge.driver", "./exefiles/msedgedriver.exe");
            // instantiate
            // and up casting Edgedriver to Webdriver
            driver = new EdgeDriver();
            //Report successful launch
            Reporter.log(" XXXXXXXXXX--- Edge Chromium Browser Launched Successfully !  ---XXXXXXXXXX", true);
        }

        // maximize browser window
        driver.manage().window().maximize();

        // navigate to test site
        // driver.get(GetPropertiesValue.getPropertyValue("demoURL"));
        driver.get(GetPropertiesValue.getPropertyValue("LibraryURL_QA"));

        // Waitstatement for implicitwait in seconds
        WaitStatementLib.implicitWaitSecs(driver,20);

    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if(result.isSuccess()) {
            // Report script is successful
            Reporter.log("Script Successful !");
        } else {
            // instantiate new ScreenshotLib class
//            ScreenshotLib screenshot = new ScreenshotLib();
            // get name for failedMethod
            String failedMethod = result.getMethod().getMethodName();
            // get screenshot
            ScreenshotLib.getScreenshot(driver, failedMethod);
            Reporter.log("Screenshot is taken for failed Test Case => "+failedMethod);
        }

        // closes the browser
        driver.close();
        Reporter.log("XXXXXXXXXX--- BROWSER CLOSED ! ---XXXXXXXXXX");

        // closes / stops the driver
        driver.quit();
        Reporter.log("XXXXXXXXXX--- DRIVER CLOSED ! ---XXXXXXXXXX");

    }

}


