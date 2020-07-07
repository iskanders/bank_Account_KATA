Feature: Check operations feature

  Background:
    Given A valid account with an empty operations

  Scenario: Print deposit money operation
    When I deposit an amount of 50 euro to the account
    And print the last operation
    Then A new deposit line should be printed


  Scenario: Print withdrawal money operation
    When I withdrawal an amount of 50 euro to the account
    And print the last operation
    Then A new withdrawal line should be printed
