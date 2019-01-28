package com.axis360.scripts;

import com.axis360.generics.BaseLib;
import com.axis360.pageObject.LandingPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LandingPageTest extends BaseLib {

    @Parameters("browser")
    @Test(priority = 1, invocationCount = 5)
    public void validateLandingPage() {

        LandingPage lp = new LandingPage();

        lp.validateTitle(driver);

    }


    @Test(priority = 2, invocationCount = 5)
    public void inValidLandingPage() {

        LandingPage lp = new LandingPage();

        lp.inValidTitle(driver);

    }

}
