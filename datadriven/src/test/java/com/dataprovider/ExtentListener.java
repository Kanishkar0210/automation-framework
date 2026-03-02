package com.dataprovider;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utiltyclass.BaseClass;

public class ExtentListener implements ITestListener {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static String reportFolder;

    // Initialize Report with Timestamp Folder
    private static ExtentReports getReportInstance() {

        if (extent == null) {

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                    .format(new Date());

            reportFolder = System.getProperty("user.dir")
                    + "/reports/" + timestamp;

            new File(reportFolder + "/screenshots").mkdirs();

            String reportPath = reportFolder + "/ExtentReport.html";

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setReportName("Automation Execution Report");
            spark.config().setDocumentTitle("Test Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Tester", "Kanishkar Ravi");
            extent.setSystemInfo("Environment", "QA");
        }

        return extent;
    }

    @Override
    public void onStart(ITestContext context) {
        getReportInstance();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest =
                extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
        attachScreenshot(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());
        attachScreenshot(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test Skipped");
        attachScreenshot(result);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    // Screenshot Method
    private void attachScreenshot(ITestResult result) {

        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseClass) currentClass).driver;

        String screenshotName = result.getMethod().getMethodName()
                + "_" + System.currentTimeMillis() + ".png";

        String screenshotPath = reportFolder
                + "/screenshots/" + screenshotName;

        File src = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File(screenshotPath));
            test.get().addScreenCaptureFromPath(screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}