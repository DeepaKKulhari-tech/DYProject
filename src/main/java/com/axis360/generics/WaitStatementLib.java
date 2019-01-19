package com.axis360.generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitStatementLib {

    // iSleep() is used for hard code wait
    public static void iSleep(int time) {
        // handle exception Interrupted Exception
        // on Thread.sleep
        try{
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // implicitlyWait for few seconds
    public static void implicitWaitSecs(WebDriver driver, int secs) {
        //implicitlyWait(), in seconds
        driver.manage().timeouts().implicitlyWait(secs, TimeUnit.SECONDS);
    }


    // implicitlyWait for few minutes
    public static void implicitWaitMins(WebDriver driver, int mins) {
        //implicitlyWait(), in minutes
        driver.manage().timeouts().implicitlyWait(mins, TimeUnit.MINUTES);
    }


    // explicitlyWait using WebDriverWait class for visiblity of WebElement element
    public static void explicitlyWaitVisible(WebDriver driver, int timeSecs, WebElement element) {
        //implicitlyWait(), in minutes
        WebDriverWait wait = new WebDriverWait(driver, timeSecs); // driver, timeSecs
        wait.until(ExpectedCondition.visibilityOf(element)); // element
    }
}
