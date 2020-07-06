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

@RunWith(MockitoJUnitRunner.class)
public class AccountOperationUnitTest {
    AccountOperation accountOperation;
    @Mock  Transaction transactionmock;

    @Before
    public void init(){
        accountOperation = new AccountOperation(Account.DEPOSIT,transactionmock,20);
    }

    @Test
    public void validequalsTest(){
        AccountOperation accountOperation1 = new AccountOperation(Account.DEPOSIT,transactionmock,20);
        Assert.assertTrue(accountOperation1.equals(accountOperation1));
    }

    @Test
    public void InvalidequalsTest(){
        AccountOperation accountOperation1 = new AccountOperation(Account.DEPOSIT,transactionmock,50);
        Assert.assertFalse(accountOperation1.equals(accountOperation1));
    }
}
