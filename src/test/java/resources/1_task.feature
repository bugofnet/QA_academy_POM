Feature: Tests for task number 1

  Scenario: Add product to the basket
    Given I go to test site
    When I choose "1" task
    And I add "2" amount for "Okulary" product with "numbers"
    And I click add product "Okulary" button
    Then I check that product "Okulary" is in the basket with amount "2"

  Scenario: Add product with arrows and Remove product from the basket
    Given I go to test site
    When I choose "1" task
    And I add "2" amount for "Okulary" product with "arrows"
    And I click add product "Okulary" button
    Then I check that product "Okulary" is in the basket with amount "2"
    When I click button "Usuń"
    Then I check that basket is empty

