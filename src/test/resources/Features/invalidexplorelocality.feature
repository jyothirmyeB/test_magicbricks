@invalidsearch
Feature: Invalid Location Search
  Scenario: Search for a property with an invalid location
    Given I am on the home page
    When I click on the "Buy" button
    And I click on "Tips and Growth" to navigate
    And I enter an invalid location "NotARealLocation"
    And I click the explore button
    Then an error message should be displayed

  Scenario: Search for a property with no location
    Given I am on the home page
    When I click on the "Buy" button
    And I click on "Tips and Growth" to navigate
    And I leave the location field blank
    And I click the explore button
    Then an error message should be displayed