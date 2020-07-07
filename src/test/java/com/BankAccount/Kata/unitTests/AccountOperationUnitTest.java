package com.BankAccount.Kata.unitTests;

import com.BankAccount.Kata.domain.Account;
import com.BankAccount.Kata.domain.AccountOperation;
import com.BankAccount.Kata.domain.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;
import java.time.LocalDate;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountOperationUnitTest {
    AccountOperation accountOperation;
    @Mock  Transaction transactionmock;
    @Mock PrintStream printer;

    @Before
    public void init(){
        accountOperation = new AccountOperation(Account.DEPOSIT,transactionmock,20);
    }

    @Test
    public void validequalsTest(){
        AccountOperation accountOperation1 = new AccountOperation(Account.DEPOSIT,transactionmock,20);
        Assert.assertTrue(accountOperation.equals(accountOperation1));
    }

    @Test
    public void InvalidequalsTest(){
        AccountOperation accountOperation1 = new AccountOperation(Account.DEPOSIT,transactionmock,50);
        Assert.assertFalse(accountOperation.equals(accountOperation1));
    }

    @Test public void
    should_print_withdrawal() {
        AccountOperation accountOperation = AccountOperation.builder().operationName(Account.WITHDRAWAL)
                .transaction(new Transaction(1000,LocalDate.now()))
                .balance(1050)
                .build();

        accountOperation.println(printer);
        verify(printer).println("withdrawal |   "+ LocalDate.now().toString() +"  |   1000.0    |   1050.0");
    }

    @Test public void
    should_print_deposit() {
        AccountOperation accountOperation = AccountOperation.builder().operationName(Account.DEPOSIT)
                .transaction(new Transaction(1000,LocalDate.now()))
                .balance(3050)
                .build();

        accountOperation.println(printer);
        verify(printer).println("deposit |   "+ LocalDate.now().toString() +"  |   1000.0    |   3050.0");
    }
}
