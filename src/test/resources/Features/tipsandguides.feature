Feature: Tips and Growth to make informed decisions
Background:
     Given I am on the shortlisted property page
  Scenario Outline:Explore tips and growth for a specific location
    When I click on the "Buy" option
    And I select the "Tips & Growth" tab
    And I enter "Ambattur,Chennai" in the explore location box
    And I click the "Explore" button
    Then I should be redirected to the result page
    
   
    