package com.pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.Reporter;

public class InvalidComparison_Page {
	//locators for invalid compare locality
    public static By errormessage1 = By.xpath("//*[@id=\"locOneValid\"]");
    public static By errormessage2 = By.xpath("//*[@id=\"locTwoValid\"]");
    public static By errorempty1 = By.xpath("//*[@id=\"locOneEmpty\"]");
    public static By errorempty2 = By.xpath("//*[@id=\"locTwoEmpty\"]");
    public static final By compareButtonNew = By.xpath("//*[@id=\"localities\"]/div/div[4]/input");
    public static By Buybar = By.xpath("//*[@id=\"buyheading\"]");
    public static final By tipsAndGrowthButton = By.linkText("Tips and Guides");
    public static final By compareTab = By.xpath("//*[@id=\"navigation\"]/div/ul/li[2]/a");
    public static final By firstLocationInput = By.xpath("//*[@id=\"locOne\"]");
    public static final By secondLocationInput = By.xpath("//*[@id=\"locTwo\"]");

    private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest extTest;

    public InvalidComparison_Page(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.extTest = extTest;
    }
    
    public boolean clickBuyTab() {
        try {
            WebElement buyButton = wait.until(ExpectedConditions.elementToBeClickable(Buybar));
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
            WebElement tipsAndGuidesButton = wait.until(ExpectedConditions.elementToBeClickable(tipsAndGrowthButton));
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
            WebElement comparetab = wait.until(ExpectedConditions.elementToBeClickable(compareTab));
            comparetab.click();
            Reporter.generateReport(driver, extTest, Status.PASS, "Successfully clicked the 'Compare' tab.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click the 'Compare' tab: " + e.getMessage());
            return false;
        }
    }

    public boolean enterLocations(String location1, String location2) {
        try {
            WebElement locationInput1 = wait.until(ExpectedConditions.elementToBeClickable(firstLocationInput));
            locationInput1.clear();
            locationInput1.sendKeys(location1);
            
            WebElement locationInput2 = wait.until(ExpectedConditions.elementToBeClickable(secondLocationInput));
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
            WebElement compareButton = wait.until(ExpectedConditions.elementToBeClickable(compareButtonNew));
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
            boolean isFirstMessageDisplayed = !driver.findElements(errormessage1).isEmpty() && driver.findElement(errormessage1).isDisplayed();
            boolean isSecondMessageDisplayed = !driver.findElements(errormessage2).isEmpty() && driver.findElement(errormessage2).isDisplayed();
            boolean isThirdMessageDisplayed = !driver.findElements(errorempty1).isEmpty() && driver.findElement(errorempty1).isDisplayed();
            boolean isFourthMessageDisplayed = !driver.findElements(errorempty2).isEmpty() && driver.findElement(errorempty2).isDisplayed();

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

