package com.axis360.pageObject;


import com.axis360.generics.WaitStatementLib;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

public class MyLibrary_Page {




//    @FindBy()
//
//    private WebDriver ;

    public static void validatePageTitle(WebDriver driver) {
        Assert.assertEquals(driver.getTitle(), "My Library");
        Reporter.log("Page Title verified", true);
    }

    public static void inValidTitle(WebDriver driver) {
        Assert.assertEquals(driver.getTitle(), "My Library");
        Reporter.log("Page Title invalid", true);
    }
}
