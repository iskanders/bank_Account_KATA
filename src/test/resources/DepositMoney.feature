Feature: Deposit money feature

  Background:
    Given A valid account

  Scenario: Successfully saving money
    When I deposit an amount of 50 euro
    Then A new transaction is recorded


  Scenario: Saving money failed
    When I deposit an amount of 0 euro
    Then An exception is thrown