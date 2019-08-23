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

  Scenario: Add 51 product to the basket and check pop up message
    Given I go to test site
    When I choose "1" task
    And I add "50" amount for "Okulary" product with "numbers"
    And I click add product "Okulary" button
    And I add "50" amount for "Kamera" product with "numbers"
    And I click add product "Kamera" button
    And I add "1" amount for "Poduszka" product with "numbers"
    And I click add product "Poduszka" button
    Then I see alert message "Łączna ilość produktów w koszyku nie może przekroczyć 100."
