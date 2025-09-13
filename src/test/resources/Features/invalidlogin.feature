@InvalidLogin
Feature: Invalid Login Scenarios
Background:
     Given I am on the homepage of magicbricks
     When I click on the login button of home page
     And I click the inner login button
     And I am redirected to the login page
#TS_MB_03     
  Scenario Outline: Login with invalid mobile number
    
    And I enter an invalid mobile number "<phone>" and captcha "<captcha>"
    Then I should see an error message for invalid mobile number

    Examples:
      | phone   | captcha |
      | 8675   | iestk    |

  Scenario Outline: Login with missing captcha
    
    And I enter a mobile number "<phone>" without captcha
    Then I should see an error message for captcha

    Examples:
      | phone      |
      | 9799875325 |

  Scenario: Login without entering any credentials
   
    And I try to proceed without entering details
    Then I should see an error message for mandatory fields