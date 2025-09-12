package com.stepdefinition;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pages.ComparePropertiesPage;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TipsContinueSteps extends BaseSteps {

    ComparePropertiesPage comparePage;
    ExtentTest extTest = Hooks.extTest;

    @Given("I am on the Explored locality page")
    public void i_am_on_the_explored_locality_page() {
        comparePage = new ComparePropertiesPage(driver, extTest);
        boolean actResult = comparePage.validateOnExploredLocalityPage();
        Assert.assertTrue(actResult, "The user is not on the explored locality page.");
    }
    
    @When("I click the Buy option")
    public void i_click_the_buy_option() {
        boolean actResult = comparePage.clickBuyOption();
        Assert.assertTrue(actResult, "Failed to click on the option.");
    }
    
    @When("I select the Tips and Growth tab")
    public void i_select_the_tips_and_growth_tab() {
        boolean actResult = comparePage.selectTipsAndGrowthTab();
        Assert.assertTrue(actResult, "Failed to select the  tab.");
    }
    
    @When("I click on the Compare tab")
    public void i_click_on_the_compare_tab() {
        boolean actResult = comparePage.clickCompareTab();
        Assert.assertTrue(actResult, "Failed to click on the tab.");
    }
    
    @When("I enter {string} in the first location box")
    public void i_enter_in_the_first_location_box(String location) {
        boolean actResult = comparePage.enterFirstLocationForComparison(location);
        Assert.assertTrue(actResult, "Failed to enter location: " + location);
    }
    
    @When("I enter {string} in the second location box")
    public void i_enter_in_the_second_location_box(String secondLocation) {
        boolean actResult = comparePage.enterSecondLocationForComparison(secondLocation);
        Assert.assertTrue(actResult, "Failed to enter second location: " + secondLocation);
    }

    @When("I enter the final Compare button")
    public void i_enter_the_final_button() {
        boolean actResult = comparePage.clickFinalCompareButton();
        Assert.assertTrue(actResult, "Failed to click the final Compare button.");
    }

    @Then("I am on comparison page and validate both location ratings")
    public void i_am_on_comparison_page_and_validate_both_location_ratings() {
        boolean actResult = comparePage.validateComparisonPage();
        Assert.assertTrue(actResult, "Comparison page validation failed.");
    }
}
