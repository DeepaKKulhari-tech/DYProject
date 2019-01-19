package com.axis360.scripts;

import com.axis360.generics.BaseLib;
import com.axis360.pageObject.LandingPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LandingPageTest extends BaseLib {

    @Parameters("browser")
    @Test(priority = 0, invocationCount = 2)
    public void validateLandingPage() {

        LandingPage lp = new LandingPage();

    }

}
