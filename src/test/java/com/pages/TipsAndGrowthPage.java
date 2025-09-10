package com.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.objectrepository.Locators;
import com.setup.Reporter;

public class TipsAndGrowthPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest extTest;

    public TipsAndGrowthPage(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.extTest = extTest;
    }
    
    public boolean validateShortlistedPage() {
    	try {
    		// Validate the presence of the new tab's header using the specific locator
            WebElement shortlistedTabHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.shortlistTabHeader));
            if (shortlistedTabHeader.isDisplayed()) {
                Reporter.generateReport(driver, extTest, Status.PASS, "Successfully navigated to the shortlisted properties");
                return true;
            } else {
                Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to navigate to the shortlisted properties page. Header not found.");
                return false;
            }
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to view shortlisted properties: " + e.getMessage());
            return false;
        }
    }


    /**
     * Clicks on the "Buy" option at the top.
     * @return true if the action is successful, false otherwise.
     */
    public boolean clickBuyOption() {
        try {
            WebElement buyOption = wait.until(ExpectedConditions.elementToBeClickable(Locators.buyOption));
            buyOption.click();
            Reporter.generateReport(driver, extTest, Status.PASS, "Clicked on the 'Buy' option.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click on the 'Buy' option: " + e.getMessage());
            return false;
        }
    }

    /**
     * Clicks on the "Tips & Growth" tab.
     * @return true if the action is successful, false otherwise.
     */
    public boolean selectTipsAndGrowthTab() {
        try {
            WebElement tipsAndGrowthTab = wait.until(ExpectedConditions.elementToBeClickable(Locators.tipsAndGrowthTab));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", tipsAndGrowthTab);
            
            // Switch to the new tab
            Set<String> allWindowHandles = driver.getWindowHandles();
            ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
            if (tabs.size() > 1) {
                driver.switchTo().window(tabs.get(tabs.size() - 1));
                Reporter.generateReport(driver, extTest, Status.PASS, "Switched to Tips & Growth tab. Current URL: " + driver.getCurrentUrl());
                return true;
            } else {
                Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to switch to a new tab. Only one tab was found.");
                return false;
            }
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to select 'Tips & Growth' tab: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Enters a location into the explore box.
     * @param location The location to enter.
     * @return true if the action is successful, false otherwise.
     */
    public boolean enterLocationForTipsAndGrowth(String location) {
        try {
            WebElement exploreLocationBox = wait.until(ExpectedConditions.elementToBeClickable(Locators.exploreLocationBox));
            exploreLocationBox.sendKeys(location);
            Reporter.generateReport(driver, extTest, Status.PASS, "Entered location '" + location + "' in the explore box.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to enter location in the explore box: " + e.getMessage());
            return false;
        }
    }

    /**
     * Clicks on the "Explore" button.
     * @return true if the action is successful, false otherwise.
     */
    public boolean clickExploreButton() {
        try {
            WebElement exploreButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.exploreButton));
            exploreButton.click();
            
            // Switch to the new tab after clicking explore
            Set<String> allWindowHandles = driver.getWindowHandles();
            ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
            if (tabs.size() > 1) {
                driver.switchTo().window(tabs.get(tabs.size() - 1));
                Reporter.generateReport(driver, extTest, Status.PASS, "Switched to the new page after clicking explore.");
                return true;
            } else {
                Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to switch to a new tab after clicking explore. Only one tab was found.");
                return false;
            }
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click the 'Explore' button: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Validates that the current page is the tips and growth page by checking for the rating element.
     * @return true if the validation is successful, false otherwise.
     */
    public boolean validateTipsAndGrowthPage() {
        try {
            WebElement ratingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.tipsAndGrowthPageRating));
            if (ratingElement.isDisplayed()) {
                Reporter.generateReport(driver, extTest, Status.PASS, "Successfully validated the result page by verifying the rating element.");
                return true;
            } else {
                Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to validate result page. Rating element not found.");
                return false;
            }
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to validate the result page: " + e.getMessage());
            return false;
        }
    }
}
