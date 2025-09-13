@invalidcomparison
Feature: Invalid Location Comparison
Background:
     Given I am on the home page for a new comparison
     When I access the "Buy" tab
     And I navigate to the "Tips and Guides" section
     And I click on the "Compare" tab
 #TS_MB_14
  Scenario: Invalid location for both comparison fields
    And I enter the first location "InvalidLocation1" and the second location "InvalidLocation2"
    And I click the compare button
    Then an error message for invalid comparison should be displayed

  Scenario: Invalid location for one field, empty for the other
    And I enter the first location "InvalidLocation" and the second location ""
    And I click the compare button
    Then an error message for invalid comparison should be displayed
  
  Scenario: Empty locations for both comparison fields
    And I enter the first location "" and the second location ""
    And I click the compare button
    Then an error message for invalid comparison should be displayed