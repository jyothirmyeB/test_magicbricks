package com.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.BaseSteps;
import com.setup.Reporter;

public class ShortlistProperty_Page {
	 public static By sortBy = By.xpath("//*[@id=\"body\"]/div[5]/div/div/div[1]/div[1]/div[1]");
     public static By hightolow = By.xpath("//*[@id=\"body\"]/div[5]/div/div/div[1]/div[1]/div/div[2]/ul/li[3]");
     public static By shortlistButton = By.xpath("//*[@id=\"cardid67922533\"]/div/div[1]/div[2]/span[2]");
     public static By mainshortlistbtn = By.xpath("//*[@id=\"propertysrp\"]/div[1]/div/div/div[2]/div[5]/span");
     public static By viewShortlistBtn = By.xpath("//*[@id=\"propertysrp\"]/div[1]/div/div/div[2]/div[5]/div/div/a");
     public static By shortlistTabHeader = By.xpath("//*[@id=\"m-tab-Shortlisted\"]");
    private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest extTest;

    public ShortlistProperty_Page(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.extTest = extTest;
    }

    /**
     * Clicks the "View Shortlisted Properties" button, switches to the new tab,
     * and validates the page title.
     * @return true if the action is successful, false otherwise.
     */
    public boolean viewShortlistedProperties() {
        try {
            WebElement viewshortlistbtn = wait.until(ExpectedConditions.elementToBeClickable(viewShortlistBtn));
            viewshortlistbtn.click();
            
            
          
            
            // Get all window handles
            Set<String> allWindowHandles = driver.getWindowHandles();
            ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
            
            // Switch to the new tab (assuming it's the second one)
            if (tabs.size() > 1) {
                driver.switchTo().window(tabs.get(tabs.size()-1));
                Reporter.generateReport(driver, extTest, Status.PASS, "Shortlisted Property page. Current URL: " + driver.getCurrentUrl());
            } else {
                Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to switch to a new tab. Only one tab was found.");
                return false;
            }

         
            
            
            // Validate the presence of the new tab's header using the specific locator
            WebElement shortlistedTabHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(shortlistTabHeader));
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
     * Clicks on the first shortlisted property in the listing.
     * @return true if the property is clicked successfully, false otherwise.
     */
    /*public boolean clickFirstShortlistedProperty() {
        try {
            // Use the more specific locator for the first property
            WebElement firstProperty = wait.until(ExpectedConditions.elementToBeClickable(Locators.shortlistedPropertyCard));
            firstProperty.click();
            Set<String> allWindowHandles = driver.getWindowHandles();
            ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
            
            if (tabs.size() > 1) {
                driver.switchTo().window(tabs.get(tabs.size()-1));
                Reporter.generateReport(driver, extTest, Status.PASS, "Switched to the property details tab.Current URL: " + driver.getCurrentUrl());
            } else {
                Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to switch to the property details tab.");
                return false;
            }

            
            
        
            Reporter.generateReport(driver, extTest, Status.PASS, "Selected first shortlisted property.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click on the first shortlisted property: " + e.getMessage());
            return false;
        }
    }*/
    public boolean sortByFilter() {
    	try {
    		BaseSteps.sleep();
    		WebElement shortlistBtn1 = wait.until(ExpectedConditions.elementToBeClickable(sortBy));
    	    shortlistBtn1.click();
    	    WebElement shortlistBtn2 = wait.until(ExpectedConditions.elementToBeClickable(hightolow));
    	    shortlistBtn2.click();
    	    Reporter.generateReport(driver, extTest, Status.PASS, "Sortby most recent filter clicked");
            return true;
    	}
    	 catch (Exception e) {
             Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click the main shortlist button: " + e.getMessage());
             return false;
    	 }
    }
    public boolean shortlistPropertyFromList() {
        try {
        	   
          	WebElement shortlistBtn3=wait.until(ExpectedConditions.elementToBeClickable(shortlistButton));
          	shortlistBtn3.click();
            WebElement shortlistBtn = wait.until(ExpectedConditions.elementToBeClickable(mainshortlistbtn));
            shortlistBtn.click();
            
            Reporter.generateReport(driver, extTest, Status.PASS, "Successfully clicked the main shortlist button.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click the main shortlist button: " + e.getMessage());
            return false;
        }
    }
    
   /* public boolean viewcontactAgentIsPresent() {
       /* try {
            // Wait for the element to be present on the page
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.contactagent));
            Reporter.generateReport(driver, extTest, Status.PASS, "View contact Agent element is present on the page.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "View contact Agent element is not present on the page: " + e.getMessage());
            return false;
        }*/
    	
   /* 	try {
       	 WebElement contactagent = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.contactagent));
            if (contactagent.isDisplayed()) {
                Reporter.generateReport(driver, extTest, Status.PASS, "View contact Agent element is present on the page:");
                return true;
            } else {
                Reporter.generateReport(driver, extTest, Status.FAIL, "View contact Agent element is not present on the page:");
                return false;
            }
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to view shortlisted properties: " + e.getMessage());
            return false;
        }
    	
    }*/
}
    
    /**
     * Closes the current browser tab and switches back to the original tab.
     * @return true if the action is successful, false otherwise.
     */
   /* public boolean closeCurrentTab() {
        try {
            Set<String> allWindowHandles = driver.getWindowHandles();
            ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
            
            if (tabs.size() > 1) {
                driver.close();
                driver.switchTo().window(tabs.get(0));
                Reporter.generateReport(driver, extTest, Status.PASS, "Successfully closed the new tab and switched back to the original one.");
                return true;
            }
            Reporter.generateReport(driver, extTest, Status.FAIL, "Could not close tab, only one window handle found.");
            return false;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to close the current tab: " + e.getMessage());
            return false;
        }
    }*/
