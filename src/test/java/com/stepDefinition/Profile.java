package com.stepDefinition;

import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Profile extends BaseSteps
{
	@Given("I am on the MagicBricks login page")
	public void i_am_on_the_magic_bricks_login_page() {
	    launchBrowser();
	}
	    @When("I click on Google")
	    public void i_click_on_google() {
	        // Write code here that turns the phrase above into concrete actions
	        throw new io.cucumber.java.PendingException();
	    }

	
}
