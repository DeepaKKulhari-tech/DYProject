package com.axis360.scripts;

import com.axis360.generics.BaseLib;
import com.axis360.pageObject.Login_Page;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPIN_Test extends BaseLib {

//    @Parameters("browser")
//    @Test(priority = 1, invocationCount = 1)
//    public void validateInvalidPatronID() {
//
//        Login_Page lp = new Login_Page(driver);
//
//        //Click on Login button - My Library Page
//        lp.clickLoginbutton();
//        //Enter login credentials(Invalid PatronId) and Click on login button
//        lp.login("BTHo","1111");
//        //Validate the error
//        lp.verifyInvalidPatronID(driver, 60);
//
//    }

    @Parameters("browser")
    @Test(priority = 0, invocationCount = 1)
    public void validateInvalidPIN() throws InterruptedException {

        Login_Page lp = new Login_Page(driver);

        //Click on Login button - My Library Page
        lp.clickLoginbutton();
        //Enter login credentials(Invalid Password) and Click on login button
        lp.login("autowebqa","1111");
        //Validate the error
        lp.verifyInvalidPIN(driver, 60);

    }
}
