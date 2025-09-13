package com.stepdefinition;

import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import com.pages.InvalidExploreLocationPage;
import com.setup.BaseSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class InvalidExploreLocationSteps extends BaseSteps {

    InvalidExploreLocationPage invalidExploreLocationPage;
    ExtentTest extTest = Hooks.extTest;
    private String homePageUrl = "https://www.magicbricks.com/";

    @Before("@invalidsearch")
    public void startBrowser() {
        // Ensure a new browser is launched for this specific scenario
        launchBrowser();
        driver.get(homePageUrl);
        System.out.println("Browser launched fresh for scenario with tag @invalidsearch");
    }

    @After("@invalidsearch")
    public void closeBrowser() {
        // Ensure the browser is closed after this specific scenario
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("Browser closed after scenario with tag @invalidsearch");
        }
    }

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        invalidExploreLocationPage = new InvalidExploreLocationPage(driver, extTest);
        String actUrl = driver.getCurrentUrl();
        Assert.assertTrue(actUrl.contains("magicbricks.com"),
                "User is not on the Magicbricks home page. Current URL: " + actUrl);
    }

    @When("I click on the {string} button")
    public void iClickOnTheButton(String buttonName) {
        if (buttonName.equalsIgnoreCase("Buy")) {
            boolean actResult = invalidExploreLocationPage.clickBuyButton();
            Assert.assertTrue(actResult, "Failed to click the 'Buy' button.");
        } else {
            Assert.fail("Button '" + buttonName + "' not recognized in this scenario.");
        }
    }

    @When("I click on {string} to navigate")
    public void iClickOnToNavigate(String buttonName) {
        if (buttonName.equalsIgnoreCase("Tips and Growth")) {
            boolean actResult = invalidExploreLocationPage.clickTipsAndGrowthAndSwitchToNewTab();
            Assert.assertTrue(actResult, "Failed to click on '" + buttonName + "' and switch to new tab.");
        } else {
            Assert.fail("Button '" + buttonName + "' not recognized in this scenario.");
        }
    }
    
    @When("I enter an invalid location {string}")
    public void iEnterAnInvalidLocation(String location) {
        boolean actResult = invalidExploreLocationPage.enterLocation(location);
        Assert.assertTrue(actResult, "Failed to enter location: " + location);
    }
    
    @When("I leave the location field blank")
    public void iLeaveTheLocationFieldBlank() {
        boolean actResult = invalidExploreLocationPage.enterLocation("");
        Assert.assertTrue(actResult, "Failed to leave location field blank.");
    }

    @When("I click the explore button")
    public void iClickTheExploreButton() {
        boolean actResult = invalidExploreLocationPage.clickExploreButton();
        Assert.assertTrue(actResult, "Failed to click on Explore button.");
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        boolean actResult = invalidExploreLocationPage.validateErrorMessage();
        Assert.assertTrue(actResult, "Failed to validate error message.");
    }
}

