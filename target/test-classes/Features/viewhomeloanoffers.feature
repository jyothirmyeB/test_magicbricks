Feature: Home Loan Application

  Scenario: Navigate to home loan offers page and validate
    Given I am on the comparison page
    When I select the Buy button
    And I click on the Home Loans tab
    And I enter "9900000" in the loan amount field
    And I enter "Chennai,TamilNadu" in the loan location field
    And I click on Check Offers button
    Then I should be redirected to the Loan offers for you page