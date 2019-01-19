package com.axis360.generics;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotLib {


    //take screenshot and save under Screenshots folder
    public static void getScreenshot(WebDriver driver, String fileName) {

        try{
            // Eventfire
            EventFiringWebDriver eventFire = new EventFiringWebDriver(driver);

            File src = eventFire.getScreenshotAs(OutputType.FILE);

            //Create new "screenshot" in "screenshots" directory.
            File dest = new File("./screenshots/"+fileName+".png");

            //copy file from source to destination
            FileUtils.copyFile(src, dest);

        } catch (WebDriverException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
