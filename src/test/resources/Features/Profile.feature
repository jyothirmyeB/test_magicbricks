@Login
Feature:Login successful
Background:
       Given I am on the homepage
#TS_MB_01,TS_MB_02       
Scenario: Valid user login successfully
  When I click on the login button
  And I am redirected to the login page and click on phonenumber
  And I enter the otp
  Then I should be redirected to the homepage


