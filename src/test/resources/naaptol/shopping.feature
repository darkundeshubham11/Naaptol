@tag
Feature: Navigation to Home Linen and Furniture

  @tag1
Scenario: Purchase a Blanket from Home Linen & Furniture Category
    Given I navigate to the Home Linen & Furniture category
    And I click on Blankets and Quilts
    When I filter and purchase a blanket
    And take a screenshot of the purchase
 