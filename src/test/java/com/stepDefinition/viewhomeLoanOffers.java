package com.stepDefinition;

import com.aventstack.extentreports.ExtentTest;
import com.pages.HomeLoanPage;
import com.setup.BaseSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class viewhomeLoanOffers extends BaseSteps {

    HomeLoanPage homeLoanPage;
    ExtentTest extTest = Hooks.extTest;

    @Given("I am on the comparison page")
    public void i_am_on_the_comparison_page() {
        homeLoanPage = new HomeLoanPage(driver, extTest);
        //Assert.assertTrue(driver.getCurrentUrl().contains("compare"), "User is not on the comparison page.");
    }

    @When("I select the Buy button")
    public void i_select_the_buy_button() {
        boolean actResult = homeLoanPage.clickBuyTab();
        Assert.assertTrue(actResult, "Failed to click on the Buy tab.");
    }
    
    @When("I click on the Home Loans tab")
    public void i_click_on_the_home_loans_tab() {
        boolean actResult = homeLoanPage.clickHomeLoansOption();
        Assert.assertTrue(actResult, "Failed to click on the Home Loans tab.");
    }

    @When("I enter {string} in the loan amount field")
    public void i_enter_in_the_loan_amount_field(String amount) {
        boolean actResult = homeLoanPage.enterLoanAmount(amount);
        Assert.assertTrue(actResult, "Failed to enter loan amount: " + amount);
    }
    
    @When("I enter {string} in the loan location field")
    public void i_enter_in_the_loan_location_field(String location) {
        boolean actResult = homeLoanPage.enterLoanLocation(location);
        Assert.assertTrue(actResult, "Failed to enter loan location: " + location);
    }

    @When("I click on Check Offers button")
    public void i_click_on_check_offers_button() {
        boolean actResult = homeLoanPage.clickCheckOffers();
        Assert.assertTrue(actResult, "Failed to click on Check Offers button.");
    }

    @Then("I should be redirected to the Loan offers for you page")
    public void i_should_be_redirected_to_the_loan_offers_for_you_page() {
        boolean actResult = homeLoanPage.validateLoanOffersPage();
        Assert.assertTrue(actResult, "Validation of 'Loan offers for you' page failed.");
    }
}
