package com.BankAccount.Kata.Exceptions;

import com.BankAccount.Kata.domain.Account;
import com.BankAccount.Kata.domain.AccountOperation;
import org.springframework.expression.Operation;

public class UnauthorizedTransactionException extends  RuntimeException {

    private static final String MESSAGE = "Unauthorized operation %s on account";

    public UnauthorizedTransactionException(String operation){
        super(String.format(MESSAGE, operation));
    }
}
