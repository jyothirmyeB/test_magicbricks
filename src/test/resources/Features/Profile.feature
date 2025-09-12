@Login
Feature:Login successful
Background:
       Given I am on the homepage
Scenario: Valid user login successfully
  When I click on the login button
  And I am redirected to the login page and click on phonenumber
  And I enter the otp
  Then I should be redirected to the homepage


