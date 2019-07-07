Feature: I perform first task
  Scenario: I see first task
    Given I go to test site
    When I choose "1" task
    And I add "2" amount for "Okulary" product
    And I click add product "Okulary" button
    Then I check that product "Okulary" is in the basket with amount "2"
