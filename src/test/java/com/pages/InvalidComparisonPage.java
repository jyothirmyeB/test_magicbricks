package com.pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.objectrepository.Locators;
import com.setup.Reporter;

public class InvalidComparisonPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest extTest;

    public InvalidComparisonPage(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.extTest = extTest;
    }
    
    public boolean clickBuyTab() {
        try {
            WebElement buyButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.Buybar));
            buyButton.click();
            Reporter.generateReport(driver, extTest, Status.PASS, "Successfully clicked the 'Buy' tab.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click the 'Buy' tab: " + e.getMessage());
            return false;
        }
    }

    public boolean clickTipsAndGuidesTabAndSwitchToNewTab() {
        try {
            WebElement tipsAndGuidesButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.tipsAndGrowthButton));
            tipsAndGuidesButton.click();

            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            Set<String> windowHandles = driver.getWindowHandles();
            
            if (windowHandles.size() > 1) {
                Iterator<String> iterator = windowHandles.iterator();
                String parentWindow = iterator.next();
                String newTab = iterator.next();
                driver.switchTo().window(newTab);
                Reporter.generateReport(driver, extTest, Status.PASS, "Clicked 'Tips and Guides' and successfully switched to new tab.");
                return true;
            } else {
                Reporter.generateReport(driver, extTest, Status.FAIL, "New tab did not open after clicking 'Tips and Guides'.");
                return false;
            }
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click 'Tips and Guides' tab and switch tabs: " + e.getMessage());
            return false;
        }
    }

    // New method to click the Compare tab
    public boolean clickCompareTab() {
        try {
            WebElement compareTab = wait.until(ExpectedConditions.elementToBeClickable(Locators.compareTab));
            compareTab.click();
            Reporter.generateReport(driver, extTest, Status.PASS, "Successfully clicked the 'Compare' tab.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click the 'Compare' tab: " + e.getMessage());
            return false;
        }
    }

    public boolean enterLocations(String location1, String location2) {
        try {
            WebElement locationInput1 = wait.until(ExpectedConditions.elementToBeClickable(Locators.firstLocationInput));
            locationInput1.clear();
            locationInput1.sendKeys(location1);
            
            WebElement locationInput2 = wait.until(ExpectedConditions.elementToBeClickable(Locators.secondLocationInput));
            locationInput2.clear();
            locationInput2.sendKeys(location2);

            Reporter.generateReport(driver, extTest, Status.PASS, "Entered locations: '" + location1 + "' and '" + location2 + "'.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to enter locations: " + e.getMessage());
            return false;
        }
    }

    public boolean clickCompareButton() {
        try {
            WebElement compareButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.compareButtonNew));
            compareButton.click();
            Reporter.generateReport(driver, extTest, Status.PASS, "Clicked 'Compare' button.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click 'Compare' button: " + e.getMessage());
            return false;
        }
    }
    public boolean validateErrorMessage() {
        try {
            // Check for the visibility of either the first or the second error message
            boolean isFirstMessageDisplayed = !driver.findElements(Locators.errormessage1).isEmpty() && driver.findElement(Locators.errormessage1).isDisplayed();
            boolean isSecondMessageDisplayed = !driver.findElements(Locators.errormessage2).isEmpty() && driver.findElement(Locators.errormessage2).isDisplayed();
            boolean isThirdMessageDisplayed = !driver.findElements(Locators.errorempty1).isEmpty() && driver.findElement(Locators.errorempty1).isDisplayed();
            boolean isFourthMessageDisplayed = !driver.findElements(Locators.errorempty2).isEmpty() && driver.findElement(Locators.errorempty2).isDisplayed();

            // The test passes if at least one of the messages is displayed
            if (isFirstMessageDisplayed || isSecondMessageDisplayed || isThirdMessageDisplayed ||isFourthMessageDisplayed) {
                Reporter.generateReport(driver, extTest, Status.PASS, "At least one expected error message is displayed.");
                return true;
            } else {
                Reporter.generateReport(driver, extTest, Status.FAIL, "Neither of the expected error messages is displayed.");
                return false;
            }
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to validate error message: " + e.getMessage());
            return false;
        }
    }
}

