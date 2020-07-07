package com.BankAccount.Kata.unitTests;

import com.BankAccount.Kata.BaseTest;
import com.BankAccount.Kata.Exceptions.UnauthorizedTransactionException;
import com.BankAccount.Kata.domain.Account;
import com.BankAccount.Kata.domain.AccountOperation;
import com.BankAccount.Kata.domain.Transaction;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.PrintStream;
import java.util.List;

import static com.BankAccount.Kata.domain.Account.LAST_OPERATION;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AccountUnitTest {

    @Mock List<AccountOperation> operations;
    @Mock Transaction transaction;
    @Mock PrintStream printer;
    Account account;

    @Before
    public void initialise() {
        account = new Account(operations,transaction);
    }

    @Test
    public void amountShouldBeAddedToBalanceAfterDeposit(){
        account.deposit(50);
        Assert.assertEquals(account.getBalance(),50, BaseTest.DELTA);
    }

    @Test
    public void shouldChangeBalanceAfterWithdrawal(){

        // Add an amount of money to the account to avoid exception.
        account.deposit(50);

        account.withdrawal(20);
        Assert.assertEquals(account.getBalance(),30, BaseTest.DELTA);
    }

    @Test
    public void lineShouldBeAddedToOperationsAfterDeposit(){
        account.deposit(50);
        verify(operations).add(eq(LAST_OPERATION),any(AccountOperation.class));
    }

    @Test public void
    printAllOperationsTest() {

        account.println(printer);

        verify(printer).println(Account.HISTORY_HEADER);
        verify(operations,times(operations.size())).get(anyInt());
    }

}
