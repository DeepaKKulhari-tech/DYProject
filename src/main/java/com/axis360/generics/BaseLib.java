package com.axis360.generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseLib {

    //declare WebDriver
    public WebDriver driver;

    // BeforeMethod testng annotation
    // to initialize browser and navigate browser to desired link
    @BeforeMethod
    @Parameters("browser") // parameter name "browser"
    public void setUp(String browseName) {

        // Launch browser based on the browserName
        // passed as an argument
        if(browseName.equalsIgnoreCase("chrome")) {
            // set key and value
            // for system property
            System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");

            // instantiate
            // and up casting Chromedriver to Webdriver
            driver = new ChromeDriver();

            //Report successful launch
            Reporter.log("Chrome Launched !", true);

        } else if(browseName.equalsIgnoreCase("firefox")) {
            // set key and value
            // for system property
            System.setProperty("webdriver.firefox.driver", "./exefiles/geckodriver.exe");

            // instantiate
            // and up casting Firefoxdriver to Webdriver
            driver = new FirefoxDriver();

            //Report successful launch
            Reporter.log("Firefox Launched !", true);

        } else {
            // set key and value
            // for system property
            System.setProperty("webdriver.edge.driver", "./exefiles/MicrosoftWebDriver.exe");

            // instantiate
            // and up casting Edgedriver to Webdriver
            driver = new EdgeDriver();

            //Report successful launch
            Reporter.log("Edge Launched !", true);
        }


    }

}
