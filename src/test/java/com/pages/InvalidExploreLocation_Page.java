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

public class InvalidExploreLocation_Page {
	// New locator for invalid location error message
	public static final By buyButton = By.xpath("//*[@id=\"buyheading\"]");
	public static By errormessage = By.xpath("//*[@id=\"locExploreEmpty\"]");
    public static final By tipsAndGrowthButton = By.linkText("Tips and Guides");
    public static final By exploreLocationBox = By.xpath("//*[@id=\"locExplore\"]");
    public static final By exploreButton = By.xpath("//*[@id=\"exploreSection\"]/div/div[2]/div[2]/div[2]/input");

    private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest extTest;

    public InvalidExploreLocation_Page(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.extTest = extTest;
    }
    
    // This method only clicks the Buy button. It does NOT handle tab switching.
    public boolean clickBuyButton() {
        try {
            WebElement buybutton = wait.until(ExpectedConditions.elementToBeClickable(buyButton));
            buybutton.click();
            Reporter.generateReport(driver, extTest, Status.PASS, "Successfully clicked the 'Buy' button.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click the 'Buy' button: " + e.getMessage());
            return false;
        }
    }
    
    // This method clicks the Tips and Growth button and handles the tab switch.
    public boolean clickTipsAndGrowthAndSwitchToNewTab() {
        try {
            WebElement tipsAndgrowthButton = wait.until(ExpectedConditions.elementToBeClickable(tipsAndGrowthButton));
            tipsAndgrowthButton.click();

            wait.until(ExpectedConditions.numberOfWindowsToBe(2));

            Set<String> windowHandles = driver.getWindowHandles();
            
            if (windowHandles.size() > 1) {
                Iterator<String> iterator = windowHandles.iterator();
                String parentWindow = iterator.next();
                String newTab = iterator.next();
                driver.switchTo().window(newTab);
                Reporter.generateReport(driver, extTest, Status.PASS, "Clicked 'Tips and Growth' and successfully switched to new tab.");
                return true;
            } else {
                Reporter.generateReport(driver, extTest, Status.FAIL, "New tab did not open after clicking 'Tips and Growth'.");
                return false;
            }
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click 'Tips and Growth' button and switch tabs: " + e.getMessage());
            return false;
        }
    }

    public boolean enterLocation(String location) {
        try {
            WebElement locationInput = wait.until(ExpectedConditions.elementToBeClickable(exploreLocationBox));
            locationInput.clear();
            locationInput.sendKeys(location);
            Reporter.generateReport(driver, extTest, Status.PASS, "Entered location: " + location);
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to enter location: " + e.getMessage());
            return false;
        }
    }

    public boolean clickExploreButton() {
        try {
            WebElement explorebutton = wait.until(ExpectedConditions.elementToBeClickable(exploreButton));
            explorebutton.click();
            Reporter.generateReport(driver, extTest, Status.PASS, "Clicked 'Explore' button.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click 'Explore' button: " + e.getMessage());
            return false;
        }
    }

    public boolean validateErrorMessage() {
        try {
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(errormessage));
            boolean isDisplayed = errorMessage.isDisplayed();
            if (isDisplayed) {
                Reporter.generateReport(driver, extTest, Status.PASS, "Error message is displayed as expected.");
            } else {
                Reporter.generateReport(driver, extTest, Status.FAIL, "Error message is not displayed.");
            }
            return isDisplayed;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to find error message: " + e.getMessage());
            return false;
        }
    }
}
