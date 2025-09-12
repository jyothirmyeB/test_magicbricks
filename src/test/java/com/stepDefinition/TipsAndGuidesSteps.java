package com.stepdefinition;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pages.TipsAndGuidesPage;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TipsAndGuidesSteps extends BaseSteps {

    TipsAndGuidesPage tipsAndGrowthPage;
    ExtentTest extTest = Hooks.extTest;

    @Given("I am on the shortlisted property page")
    public void i_am_on_the_shortlisted_property_page() {
        tipsAndGrowthPage = new TipsAndGuidesPage(driver, extTest);
        boolean actResult = tipsAndGrowthPage.validateShortlistedPage();
        Assert.assertTrue(actResult, "User is not on the shortlisted property page.");
    }

    @When("I click on the {string} option")
    public void i_click_on_the_option(String option) {
        boolean actResult = tipsAndGrowthPage.clickBuyOption();
        Assert.assertTrue(actResult, "Failed to click on the 'Buy' option.");
    }

    @When("I select the {string} tab")
    public void i_select_the_tab(String tabName) {
        boolean actResult = tipsAndGrowthPage.selectTipsAndGrowthTab();
        Assert.assertTrue(actResult, "Failed to select the 'Tips & Growth' tab.");
    }
    
    @When("I enter {string} in the explore location box")
    public void i_enter_in_the_explore_location_box(String location) {
    	boolean actResult = tipsAndGrowthPage.enterLocationForTipsAndGrowth(location);
    	Assert.assertTrue(actResult, "Failed to enter location: " + location);
    }

    @When("I click the {string} button")
    public void i_click_the_button(String buttonName) {
        boolean actResult = tipsAndGrowthPage.clickExploreButton();
        Assert.assertTrue(actResult, "Failed to click the 'Explore' button.");
    }

    @Then("I should be redirected to the result page")
    public void i_should_be_redirected_to_the_result_page() {
        boolean actResult = tipsAndGrowthPage.validateTipsAndGrowthPage();
        Assert.assertTrue(actResult, "User is not on the result page.");
    }
}
