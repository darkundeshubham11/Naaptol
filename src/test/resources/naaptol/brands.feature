@tag
Feature: Navigate to brands

  @tag1
  Scenario: Navigate to brands
    Given I have navigated to the Brands section
    And I am on the Branded category page
    When I filter the Branded items based on my preference
    And Close Window