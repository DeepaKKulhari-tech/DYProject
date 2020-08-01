package com.axis360.generics;

import com.relevantcodes.extentreports.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.*;

import java.io.*;
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
        reports = new ExtentReports("./testReports/"+"report_"+new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "/report.html");
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
