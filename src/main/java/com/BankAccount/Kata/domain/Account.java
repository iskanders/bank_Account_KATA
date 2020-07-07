package com.BankAccount.Kata.domain;

/**
 * Account Class that represent the account of a client.
 * It has a unique constructor with 2 args
 * This class provide deposit service that work with the flowing logic :
 *   - for each deposit amount a transaction is created
 *   - than the transaction is executed to get the balance result
 *   - than a new line of operation is add in head in the head of the history operations
 *
 *
 * The LAST_OPERATION constant indicate the index where the last operation should be added
 * */

import com.BankAccount.Kata.Exceptions.UnauthorizedTransactionException;

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Account {

    public final static int LAST_OPERATION = 0;
    public final static String  DEPOSIT = "deposit";
    public final static String  WITHDRAWAL = "withdrawal";
    public static final String HISTORY_HEADER = "operation  |   date        |   amount  |   balance";


    public List<AccountOperation> history ;
    private double balance=0;
    private Transaction currentTransaction;

    /**
     * Account class constructor with 2 args
     *
     * @param history for the initial history of the account
     * @param transaction optional arg used for the test.
     * @return Account instance
     * */
    public Account(List<AccountOperation> history, Transaction... transaction){
        this.history=history;
        currentTransaction = transaction.length>0 ? transaction[0] : null;
    }

    /**
     * This function is the entry point for the deposit service
     *
     * @param amount the amount of money to deposit
     * @throws UnauthorizedTransactionException if the amount to be add is negative or zero
     *
     * @see #recordTransaction
     * */
    public void deposit(double amount){
        if(amount<=0) throw new UnauthorizedTransactionException(DEPOSIT);
        recordTransaction(amount,LocalDate.now(),DEPOSIT);
    }


    /**
     * This function is the entry point for the withdrawal operation
     *
     * @param amount the amount of money to retrieve
     * @throws UnauthorizedTransactionException if
     *                                             - The amount to be retrieved is negative or zero.
     *                                             - The amount is grater than the balance.
     *
     * @see #recordTransaction
     * */
    public void withdrawal(double amount){
        if(amount<=0 || amount > balance) throw new UnauthorizedTransactionException(WITHDRAWAL);
        recordTransaction(-amount, LocalDate.now() , WITHDRAWAL);
    }

    /**
     * recordTransaction method operate and save the transaction
     *
     * @param amount the value to deposit in the account
     * @param date the date and hour of the transaction
     * @param transactionName can be deposit or withdrawal
     * */
    private void recordTransaction(double amount, LocalDate date, String transactionName) {
        currentTransaction = currentTransaction==null ? new Transaction(amount, date) : currentTransaction;
        AccountOperation operation = AccountOperation.builder()
                .operationName(transactionName)
                .transaction(currentTransaction)
                .balance(getBalance())
                .build();
        balance = currentTransaction.execute(this.balance);
        operation.setBalance(balance);
        history.add(LAST_OPERATION,operation);
    }

    public void println(PrintStream printer){}

    public double getBalance(){
        return this.balance;
    }

    public Transaction getCurrentTransaction() {
        return this.currentTransaction;
    }
}
