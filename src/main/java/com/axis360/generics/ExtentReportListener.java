package com.axis360.generics;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportListener implements ITestListener {

    // public Webdriver needs to be declared ??
    private static ExtentReports reports;
    private static ExtentTest test;

    public void onTestStart(ITestResult result) {
        test = reports.startTest(result.getMethod().getMethodName());
        test.log(LogStatus.INFO,result.getMethod().getMethodName()+"Test Started");
    }

    public static void onTestFailure(ITestResult result, WebDriver driver) {

        String detail = result.getMethod().getMethodName();

        test.log(LogStatus.FAIL, detail + "Test Failed");
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File("./screenshots"+detail+".png"));
            String file = test.addScreenCapture("./screenshots" + detail + ".png");
            test.log(LogStatus.FAIL, detail + "Test Failed", file);
            test.log(LogStatus.FAIL, detail + "Test Failed", result.getThrowable().getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        test.log(LogStatus.SKIP, result.getMethod().getMethodName() + "Test Skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        Reporter.log("On Test Success within Percentage");
    }

    public void onStart(ITestContext context) {
        reports = new ExtentReports(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "reports.html");
    }

    public void onFinish(ITestContext context) {
        reports.endTest(test);
        reports.flush();
    }

// WIP - implementation of following two methods required ???
    public void onTestSuccess(ITestResult iTestResult) {

    }

    public void onTestFailure(ITestResult iTestResult) {

    }

}
