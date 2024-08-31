@tag
Feature: Purchase items in the Furniture category
  @tag1
   Scenario: Purchase a Storage Cabinet
    Given I have navigated to the Furniture section
      And I am on the Furniture category page
    When I click on the Storage Cabinets section
      And I filter the Storage Cabinets based on my preference
      And Close Browser
