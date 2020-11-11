package com.axis360.scripts;

import com.axis360.generics.BaseLib;
import com.axis360.pageObject.MyLibrary_Page;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MyLibraryUI_Test extends BaseLib {

    @Parameters("browser")
    @Test(priority = 1, invocationCount = 1)
    public void validateLandingPage() {

        MyLibrary_Page lp = new MyLibrary_Page();

        lp.validatePageTitle(driver);

    }


    @Test(priority = 2, invocationCount = 1)
    public void inValidLandingPage() {

        MyLibrary_Page lp = new MyLibrary_Page();

        lp.inValidTitle(driver);

    }

}
