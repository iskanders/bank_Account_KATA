Feature: Deposit money feature

  Scenario: Save money
    Given A valid account
    When I deposit an amount of money
    Then A new transaction is recorded