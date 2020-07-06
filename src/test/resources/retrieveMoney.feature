Feature: Retrieve  money feature

  Background:
    Given A valid account

  Scenario: Successfully retrieve money
    When I retrieve an amount of 50 euro
    Then A new retrieve transaction is recorded


  Scenario: retrieve money failed
    When I retrieve an amount grater than the balance
    Then A new exception is thrown
