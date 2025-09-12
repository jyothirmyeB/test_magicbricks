Feature: Compare Two Propertiesto make Decisions
Background:
     Given I am on the Explored locality page
     When I click the Buy option
  Scenario: Compare Ambattur Chennai with Tambaram Chennai
    And I select the Tips and Growth tab
    And I click on the Compare tab
    And I enter "Ambattur,Chennai" in the first location box
    And I enter "Tambaram,Chennai" in the second location box
    And I enter the final Compare button
    Then I am on comparison page and validate both location ratings