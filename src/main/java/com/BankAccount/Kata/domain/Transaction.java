package com.BankAccount.Kata.domain;


/**
 * The transaction class used to execute the request operation
 * from the client.
 * It has 2 constructors, and it uses lombok library for the implementation.
 *
 * Attribute :
 *   - amount : the amount of money of the transaction that can be
 *              positive or negative according to the type of the operation.
 *   - Date : the date and time of the transaction.
 * */
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Transaction {

    private double amount;
    private LocalDate depositDate;

    /**
     * Execute function used to operate the transaction
     *
     * @param balance the current balance of the account before execution transaction
     * @return the new value of the balance after execution transaction
     * */
    public double execute(double balance){
        return balance+amount;
    }

    public double getValue() {
        return this.amount;
    }
}
