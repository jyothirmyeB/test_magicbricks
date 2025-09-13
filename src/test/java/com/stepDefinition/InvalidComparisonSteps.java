package com.stepdefinition;

import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import com.pages.InvalidComparison_Page;
import com.setup.BaseSteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class InvalidComparisonSteps extends BaseSteps {

    InvalidComparison_Page invalidComparisonPage;
    ExtentTest extTest = Hooks.extTest;
    private String homePageUr = "https://www.magicbricks.com/";

    @Before("@invalidcomparison")
    public void startBrowser() {
        // Ensure a new browser is launched for this specific scenario
        launchBrowser();
        driver.get(homePageUr);
        System.out.println("Browser launched fresh for scenario with tag @invalidcomparison");
    }

    @After("@invalidcomparison")
    public void closeBrowser() {
        // Ensure the browser is closed after this specific scenario
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("Browser closed after scenario with tag @invalidcomparison");
        }
    }

    @Given("I am on the home page for a new comparison")
    public void iAmOnTheHomePageForANewComparison() {
        invalidComparisonPage = new InvalidComparison_Page(driver, extTest);
        String actUrl = driver.getCurrentUrl();
        Assert.assertTrue(actUrl.contains("magicbricks.com"),
                "User is not on the Magicbricks home page. Current URL: " + actUrl);
    }
    
    @When("I access the {string} tab")
    public void iAccessTheTab(String tabName) {
        if (tabName.equalsIgnoreCase("Buy")) {
            boolean result = invalidComparisonPage.clickBuyTab();
            Assert.assertTrue(result, "Failed to click the '" + tabName + "' tab.");
        } else {
            Assert.fail("Tab name not recognized: " + tabName);
        }
    }
    
    @And("I navigate to the {string} section")
    public void iNavigateToTheSection(String sectionName) {
        if (sectionName.equalsIgnoreCase("Tips and Guides")) {
            boolean result = invalidComparisonPage.clickTipsAndGuidesTabAndSwitchToNewTab();
            Assert.assertTrue(result, "Failed to click the '" + sectionName + "' section and switch to new tab.");
        } else {
            Assert.fail("Section name not recognized: " + sectionName);
        }
    }
    
    // New step to click the Compare tab
    @And("I click on the {string} tab")
    public void iClickOnTheTab(String tabName) {
        if (tabName.equalsIgnoreCase("Compare")) {
            boolean result = invalidComparisonPage.clickCompareTab();
            Assert.assertTrue(result, "Failed to click the '" + tabName + "' tab.");
        } else {
            Assert.fail("Tab name not recognized: " + tabName);
        }
    }

    @And("I enter the first location {string} and the second location {string}")
    public void iEnterTheFirstLocationAndTheSecondLocation(String location1, String location2) {
        boolean result = invalidComparisonPage.enterLocations(location1, location2);
        Assert.assertTrue(result, "Failed to enter locations.");
    }

    @And("I click the compare button")
    public void iClickTheCompareButton() {
        boolean result = invalidComparisonPage.clickCompareButton();
        Assert.assertTrue(result, "Failed to click the compare button.");
    }
    
    @Then("an error message for invalid comparison should be displayed")
    public void anErrorMessageForInvalidComparisonShouldBeDisplayed() {
        boolean result = invalidComparisonPage.validateErrorMessage();
        Assert.assertTrue(result, "Error message for invalid comparison was not displayed.");
    }
}
