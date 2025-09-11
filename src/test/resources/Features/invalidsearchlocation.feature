@invalidsearch
Feature: Search Home Invalid Scenarios

  Scenario: Invalid location entered
    Given I am on the Magicbricks home page
    When I enter "Invalid Location" in the Search bar
    And I click on the Search button
    Then user should remain on the home page

  Scenario: No location entered
    Given I am on the Magicbricks home page
    When I enter "" in the Search bar
    And I click on the Search button
    Then user should remain on the home page
