package com.axis360.generics;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotLib {


    public static void getScreenshot(WebDriver driver, String fileName) {

        try{
            EventFiringWebDriver eventFire = new EventFiringWebDriver(driver);

            File src = eventFire.getScreenshotAs(OutputType.FILE);

        } catch (WebDriverException | IOException e) {
            e.printStackTrace();
        }

    }

}
