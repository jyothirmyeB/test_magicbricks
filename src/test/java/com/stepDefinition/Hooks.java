package com.stepDefinition;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.setup.BaseSteps;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks extends BaseSteps {

    static ExtentSparkReporter spark;
    static ExtentReports extReports;
    public static ExtentTest extTest;
    public static int currentrow = 0;

   	public static int firstrow;

    @BeforeAll
    public static void setUpReportsAndBrowser() {
        //  Setup reports
        spark = new ExtentSparkReporter("reports\\ExtentReports.html");
        extReports = new ExtentReports();
        extReports.attachReporter(spark);

        //  Launch browser once for all features
        if (driver == null) {
            launchBrowser();
            System.out.println("Browser launched once via @BeforeAll ");
        }
    }
    
    public static void cleanOldReports() {
        File reportsDir = new File("reports");
        if (reportsDir.exists()) {
            for (File file : reportsDir.listFiles()) {
                file.delete();
            }
        }

        File targetDir = new File("target");
        if (targetDir.exists()) {
            for (File file : targetDir.listFiles()) {
                file.delete();
            }
        }
    }


    @AfterAll
    public static void afterAll() {
       if (driver != null) {
            driver.quit();
            System.out.println("Browser closed after all tests ");}
        extReports.flush();
    }

    @Before
    public void setUpScenario(Scenario scenario) {
        // Create test entry for reporting per scenario
        extTest = extReports.createTest(scenario.getName());
    }

    // 📌 Step-level screenshots: captured immediately when a step fails
    @AfterStep
    public void captureStepScreenshot(Scenario scenario) {
        if (scenario.isFailed() && driver != null) {
            saveScreenshot(scenario);
        }
    }

    //  Helper for screenshots
    private void saveScreenshot(Scenario scenario) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String fileName = scenario.getName().replace(" ", "_") 
                              + "step" + timestamp + ".png";
            String path = "reports/screenshots" + fileName;

            File dest = new File(path);
            dest.getParentFile().mkdirs();
            FileHandler.copy(src, dest);

            // Attach screenshot to Extent report
            extTest.addScreenCaptureFromPath(path);
            extTest.fail("Screenshot captured for failed step: " + scenario.getName());

        } catch (Exception e) {
            extTest.fail("Failed to capture screenshot: " + e.getMessage());
        }
    }
}
