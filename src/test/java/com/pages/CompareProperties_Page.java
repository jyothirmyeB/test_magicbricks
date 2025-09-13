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
import com.setup.Reporter;

public class CompareProperties_Page {
	
	// for compare on tips and guides
	public static final By tipsAndGrowthPageRating = By.xpath("//*[@id=\"idOverview\"]/div[1]/div[2]/span");
    public static final By buyButton = By.xpath("//*[@id=\"buyheading\"]");
    public static final By tipsAndGrowthTabNew = By.xpath("//*[@id=\"header-buy-drop\"]/div/div/div/div[5]/ul/li[4]/a");
    public static final By compareTab = By.xpath("//*[@id=\"navigation\"]/div/ul/li[2]/a");
    public static final By firstLocationInput = By.xpath("//*[@id=\"locOne\"]");
    public static final By secondLocationInput = By.xpath("//*[@id=\"locTwo\"]");
    public static final By compareButtonNew = By.xpath("//*[@id=\"localities\"]/div/div[4]/input");
    public static final By ratingOne = By.xpath("//*[@id=\"rating_1_0\"]/div[1]/div/div[1]/span[1]");
    public static final By ratingTwo = By.xpath("//*[@id=\"rating_2_0\"]/div[1]/div/div[1]/span[1]");

    private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest extTest;

    public CompareProperties_Page(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.extTest = extTest;
    }

    /**
     * Validates that the user is on the property listing page from the previous scenario.
     * @return true if the `sortBy` dropdown is displayed, false otherwise.
     */
    public boolean validateOnExploredLocalityPage() {
        try {
            WebElement sortBy = wait.until(ExpectedConditions.visibilityOfElementLocated(tipsAndGrowthPageRating));
            if (sortBy.isDisplayed()) {
                Reporter.generateReport(driver, extTest, Status.PASS, "Successfully validated the user is on the explored locality page.");
                return true;
            } else {
                Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to validate the user is on the explored locality page. 'Sort By' dropdown not found.");
                return false;
            }
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to validate the explored locality page: " + e.getMessage());
            return false;
        }
    }


    /**
     * Clicks on the "Buy" option at the top.
     * @return true if the action is successful, false otherwise.
     */
    public boolean clickBuyOption() {
        try {
            WebElement buyOption = wait.until(ExpectedConditions.elementToBeClickable(buyButton));
            buyOption.click();
            Reporter.generateReport(driver, extTest, Status.PASS, "Clicked on the Buy option.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click on the Buy option: " + e.getMessage());
            return false;
        }
    }

    /**
     * Clicks on the "Tips & Growth" tab.
     * @return true if the action is successful, false otherwise.
     */
    public boolean selectTipsAndGrowthTab() {
        try {
            WebElement tipsAndGrowthTab = wait.until(ExpectedConditions.elementToBeClickable(tipsAndGrowthTabNew));
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
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to select Tips & Growth tab: " + e.getMessage());
            return false;
        }
    }

    /**
     * Clicks on the "Compare" tab.
     * @return true if the action is successful, false otherwise.
     */
    public boolean clickCompareTab() {
        try {
            WebElement comparetab = wait.until(ExpectedConditions.elementToBeClickable(compareTab));
            comparetab.click();
            Reporter.generateReport(driver, extTest, Status.PASS, "Clicked on the Compare tab.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click on the Compare tab: " + e.getMessage());
            return false;
        }
    }

    /**
     * Enters a location into the first explore box.
     * @param location The location to enter.
     * @return true if the action is successful, false otherwise.
     */
    public boolean enterFirstLocationForComparison(String location) {
        try {
            WebElement firstlocationInput = wait.until(ExpectedConditions.elementToBeClickable(firstLocationInput));
            firstlocationInput.sendKeys(location);
            Reporter.generateReport(driver, extTest, Status.PASS, "Entered first location '" + location + "' for comparison.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to enter first location in the explore box: " + e.getMessage());
            return false;
        }
    }

    /**
     * Enters the second locality for comparison.
     * @param secondLocation The second location to compare.
     * @return true if the action is successful, false otherwise.
     */
    public boolean enterSecondLocationForComparison(String secondLocation) {
        try {
            WebElement secondlocationInput = wait.until(ExpectedConditions.elementToBeClickable(secondLocationInput));
            secondlocationInput.sendKeys(secondLocation);
            Reporter.generateReport(driver, extTest, Status.PASS, "Entered second location '" + secondLocation + "' for comparison.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to enter the second location: " + e.getMessage());
            return false;
        }
    }

    /**
     * Clicks the final Compare button.
     * @return true if the action is successful, false otherwise.
     */
    public boolean clickFinalCompareButton() {
        try {
            WebElement finalCompareButton = wait.until(ExpectedConditions.elementToBeClickable(compareButtonNew));
            finalCompareButton.click();

            // Switch to the new tab
            Set<String> allWindowHandles = driver.getWindowHandles();
            ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
            if (tabs.size() > 1) {
                driver.switchTo().window(tabs.get(tabs.size() - 1));
                Reporter.generateReport(driver, extTest, Status.PASS, "Switched to the new comparison page tab.");
                return true;
            } else {
                Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to switch to a new tab after clicking final compare. Only one tab was found.");
                return false;
            }
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click the final Compare button: " + e.getMessage());
            return false;
        }
    }

    /**
     * Validates the comparison page by checking the ratings of both locations.
     * @return true if the validation is successful, false otherwise.
     */
    public boolean validateComparisonPage() {
        try {
            WebElement firstLocationRating = wait.until(ExpectedConditions.visibilityOfElementLocated(ratingOne));
            WebElement secondLocationRating = wait.until(ExpectedConditions.visibilityOfElementLocated(ratingTwo));

            if (firstLocationRating.isDisplayed() && secondLocationRating.isDisplayed()) {
                Reporter.generateReport(driver, extTest, Status.PASS, "Successfully validated both location ratings on the comparison page.");
                return true;
            } else {
                Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to validate ratings on the comparison page. One or both ratings not found.");
                return false;
            }
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to validate the comparison page: " + e.getMessage());
            return false;
        }
    }
}