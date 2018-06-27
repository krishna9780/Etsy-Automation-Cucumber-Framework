Feature: Run Unit Test Scenario

As a user
I want to automate etsy.com
so that I can test functionality

Scenario: Etsy test scenario
  Given I navigate to the etsy homepage
  Then I want to accept privacy settings
  And I want to enter partial search string "sp"
  When I want to search for given string "sports shoes"
  Then I want to sort results by "Lowest Price"
  And I want to get first "10" prices