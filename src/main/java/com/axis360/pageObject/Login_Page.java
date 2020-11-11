package com.axis360.pageObject;

import com.axis360.generics.WaitStatementLib;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;


/**
 * Sample code added below for understanding purpose. Hence not an actual implementation.
 * **/

public class Login_Page {

    // constructor initializes WebElement
    public Login_Page(WebDriver driver) {
        // PageFactory class to initialize using initElements() with arguments driver, this
        PageFactory.initElements(driver, this);
    }

    // store My Library page login button element
    @FindBy(id = "loginBtn")
    @CacheLookup
    private WebElement loginButton;

    // stores user name element
    @FindBy(id = "LogOnModel_UserName")
    @CacheLookup
    private WebElement userNameTextBox;

    // stores password element
    @FindBy(id = "LogOnModel_Password")
    @CacheLookup
    private WebElement passwordTextBox;

    //store Modal login button element
    @FindBy(xpath = "//button[contains(@class,'btn btn-Popuplogin')]")
    @CacheLookup
    private WebElement loginButtonModal;

    // stores error element
//    @FindBy(xpath = "//div[@class='login-form-box']/div[@id='loginHeaders']")
//    @FindBy(xpath = "//*[@id='loginHeaders']")
    private WebElement loginError;

    // store close icon element
    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div[1]/button/span/svg")
    @CacheLookup
    private WebElement closeIcon;


    // open Login Modal
    public void clickLoginbutton() {
        // click on login button
        loginButton.click();
        //Report if validated above
        Reporter.log("Clicked on My Library page - Login Button");
    }

    // close Login modal
    public void clickCloseIcon() {
        // click on close icon
        closeIcon.click();
        //Report if validated above
        Reporter.log("Clicked on the Close icon - Login Modal");
    }

    // Enter Login Credentials and click on Login Button
    public void login(String patronId, String password) throws InterruptedException {
        // Enter Patron ID
        userNameTextBox.sendKeys(patronId);
        // Report
        Reporter.log("PatronID: "+patronId+" entered.");
        // Enter Password
        passwordTextBox.sendKeys(password);// enter password
        // Report
        Reporter.log("Password: "+password+" entered.");
        // click login button
        loginButtonModal.click();

        Thread.sleep(20000);
        // Report
        Reporter.log("Clicked on the Login button - Login Modal.");
    }


    // verify Invalid PIN
    public void verifyInvalidPIN(WebDriver driver,int time) {
       try {
           String errorText = loginError.getText();
           WebElement loginErrorElement = loginError;
           String pinErrorMsg = "Login Failed. Please check your PIN";

//           Thread.sleep(20000);
           //Wait until element is visible
           WaitStatementLib.explicitlyWaitTextVisible(driver, loginErrorElement, errorText);

           // validate error
           Assert.assertEquals(errorText, pinErrorMsg);
           //Report if validated above
           Reporter.log("Invalid login Verified", true);
       } catch (WebDriverException e) {
           System.out.println("Exception occurred !");
       }
    }

//    // verify Invalid Patron ID
//    public void verifyInvalidPatronID(WebDriver driver,int time) {
//
//        try {
//                String errorText = loginError.getText().toString();
//                boolean b = errorText.isEmpty();
//                WebElement loginErrorElement = loginError;
//                String invalidPatronIdErrorMsg = "Invalid library card: BTHo";
//
//                if(b=true) {
//
//                    //Wait until element is visible
//                    WaitStatementLib.explicitlyWaitTextVisible(driver, loginErrorElement, invalidPatronIdErrorMsg);
//
//                    // validate error
//                    Assert.assertEquals(errorText, invalidPatronIdErrorMsg);
//                    //Report if validated above
//                    Reporter.log("Invalid library card: BTHo - error verified successfully !", true);
//
//                } else {
//                    // validate error
//                    Assert.assertEquals(errorText, invalidPatronIdErrorMsg);
//                    //Report if validated above
//                    Reporter.log("Invalid library card: BTHo - error verified successfully !", true);
//                }
//
//        } catch (WebDriverException e) {
//            System.out.println("Exception occurred !");
//        }
//    }


}
