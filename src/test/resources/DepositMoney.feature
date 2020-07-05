Feature: Deposit money feature

  Scenario: Successfully saving money
    Given A valid account
    When I deposit an amount of 50 euro
    Then A new transaction is recorded


  Scenario: saving money failed
    Given A valid account
    When I deposit an amount of 0 euro
    Then An exception is thrown