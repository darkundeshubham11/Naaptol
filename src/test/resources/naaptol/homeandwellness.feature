@tag
Feature: Navigate to Home and Wellness

  @tag1
  Scenario: Navigate to Home and Wellness
    Given I have navigated to the Home Linen and Furniture section
      And I am on the Home and Wellness category page
    When I filter the items based on my preference select an item to purchase
     And close browser