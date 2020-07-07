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

import java.util.List;

import static com.BankAccount.Kata.domain.Account.LAST_OPERATION;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountUnitTest {

    @Mock List<AccountOperation> operations;
    @Mock Transaction transaction;
    Account account;

    @Before
    public void initialise() {
        account = new Account(operations,transaction);
    }

    @Test
    public void amountShouldBeAddedToBalanceAfterDeposit(){
        when(transaction.execute(0)).thenReturn(50.0);
        account.deposit(50);
        Assert.assertEquals(account.getBalance(),50, BaseTest.DELTA);
    }

    @Test
    public void shouldChangeBalanceAfterWithdrawal(){
        when(transaction.execute(0)).thenReturn(50.0);

        // Add an amount of money to the account to avoid exception.
        account.deposit(50);

        when(transaction.execute(50)).thenReturn(30.0);
        account.withdrawal(20);
        Assert.assertEquals(account.getBalance(),30, BaseTest.DELTA);
    }

    @Test
    public void lineShouldBeAddedToOperationsAfterDeposit(){
        when(transaction.execute(0)).thenReturn(50.0);
        account.deposit(50);
        verify(operations).add(eq(LAST_OPERATION),any(AccountOperation.class));
    }




}
