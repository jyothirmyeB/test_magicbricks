Feature: Tips and Growth to make informed decisions
  Scenario: Explore tips and growth for a specific location
    Given I am on the shortlisted property page
    When I click on the "Buy" option
    And I select the "Tips & Growth" tab
    And I enter "Ambattur , chennai" in the explore location box
    And I click the "Explore" button
    Then I should be redirected to the result page