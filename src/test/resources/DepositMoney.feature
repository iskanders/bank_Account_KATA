Feature: Deposit money feature

  Scenario: Save money
    Given A valid account
    When I deposit an amount of 50 euro
    Then A new transaction is recorded