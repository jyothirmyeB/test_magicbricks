package com.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.objectrepository.Locators;
import com.setup.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeLoanPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest extTest;

    public HomeLoanPage(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.extTest = extTest;
    }

    /**
     * Clicks on the "Buy" tab at the top.
     * @return true if the action is successful, false otherwise.
     */
    public boolean clickBuyTab() {
        try {
            WebElement buyTab = wait.until(ExpectedConditions.elementToBeClickable(Locators.buyTab));
            buyTab.click();
            Reporter.generateReport(driver, extTest, Status.PASS, "Clicked on the Buy tab.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click on the Buy tab: " + e.getMessage());
            return false;
        }
    }

    /**
     * Clicks on the "Home Loans" option.
     * @return true if the action is successful, false otherwise.
     */
    public boolean clickHomeLoansOption() {
        try {
            WebElement homeLoansTab = wait.until(ExpectedConditions.elementToBeClickable(Locators.homeLoansTab));
            homeLoansTab.click();
            Reporter.generateReport(driver, extTest, Status.PASS, "Clicked on the Home Loans option.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click on the Home Loans option: " + e.getMessage());
            return false;
        }
    }

    /**
     * Enters a loan amount after clearing the input field.
     * @param amount The loan amount to enter.
     * @return true if the action is successful, false otherwise.
     */
    public boolean enterLoanAmount(String amount) {
        try {
            WebElement loanAmountInput = wait.until(ExpectedConditions.elementToBeClickable(Locators.loanAmountInput));
            loanAmountInput.clear();
            loanAmountInput.sendKeys(amount);
            Reporter.generateReport(driver, extTest, Status.PASS, "Entered loan amount: " + amount);
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to enter loan amount: " + e.getMessage());
            return false;
        }
    }

    /**
     * Enters a location and selects it from the dropdown after clearing the input field.
     * @param location The location to enter.
     * @return true if the action is successful, false otherwise.
     */
    public boolean enterLoanLocation(String location) {
        try {
            WebElement cityInput = wait.until(ExpectedConditions.elementToBeClickable(Locators.cityInput));
            cityInput.clear();
            cityInput.sendKeys(location);
            
            // Wait for the dropdown to appear and click the first option
            WebElement cityDropdown = wait.until(ExpectedConditions.elementToBeClickable(Locators.cityDropdown));
            cityDropdown.click();
            
            Reporter.generateReport(driver, extTest, Status.PASS, "Entered and selected location: " + location);
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to enter and select location: " + e.getMessage());
            return false;
        }
    }

    /**
     * Clicks on the "Check Offers" button and waits for the offers page to load.
     * @return true if the action is successful, false otherwise.
     */
    public boolean clickCheckOffers() {
        try {
            WebElement checkOffersButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.checkOffersButton));
            checkOffersButton.click();
            WebElement skip = wait.until(ExpectedConditions.elementToBeClickable(Locators.skipToOffers));
            skip.click();
            // Wait for the transient page to disappear (pop-up)
            Thread.sleep(9000);
            
            // Wait for the loan offers page to be visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.loanReqBox));
            
            Reporter.generateReport(driver, extTest, Status.PASS, "Clicked Check Offers and waited for the loan offers page to load.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click Check Offers or validate loan offers page: " + e.getMessage());
            return false;
        }
    }

    /**
     * Validates that the "Loan offers for you" page is displayed by checking for the presence of key elements.
     * @return true if the key elements are found, false otherwise.
     */
    public boolean validateLoanOffersPage() {
        try {
            WebElement loanReqBox = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.loanReqBox));
            WebElement creditScore = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.creditScore));

            if (loanReqBox.isDisplayed() && creditScore.isDisplayed()) {
                Reporter.generateReport(driver, extTest, Status.PASS, "Successfully validated the Loan offers for you page.");
                return true;
            } else {
                Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to validate the Loan offers for you page. Key elements not found.");
                return false;
            }
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Validation of the Loan offers for you page failed: " + e.getMessage());
            return false;
        }
    }
}