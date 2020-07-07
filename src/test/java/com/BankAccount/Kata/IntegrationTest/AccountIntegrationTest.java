package com.BankAccount.Kata.IntegrationTest;

/**
 *
 * */
import com.BankAccount.Kata.BaseTest;
import com.BankAccount.Kata.domain.Account;
import com.BankAccount.Kata.domain.AccountOperation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static com.BankAccount.Kata.domain.Account.LAST_OPERATION;

public class AccountIntegrationTest extends BaseTest{

    List<AccountOperation> operations;
    Account account;

    @Before
    public void initialise() {
        operations=new ArrayList<>();
        account = new Account(operations);
    }

    @Test
    public void depositTest(){

        account.deposit(50);
        AccountOperation operation = operations.get(LAST_OPERATION);


        Assert.assertEquals(operation.toString(),Account.DEPOSIT);
        Assert.assertEquals(operation.getTransaction().getValue(),this.transaction.getValue(),BaseTest.DELTA);
        Assert.assertEquals(50,account.getBalance(),BaseTest.DELTA);
    }

    @Test
    public void WithdrawalTest(){

        // Add an amount of money to the account to avoid exception.
        account.deposit(50);


        account.withdrawal(20);
        AccountOperation operation = operations.get(LAST_OPERATION);

        Assert.assertEquals(operation.toString(),Account.WITHDRAWAL);
        Assert.assertEquals(operation.getTransaction().getValue(),20,BaseTest.DELTA);
        Assert.assertEquals(30,account.getBalance(),BaseTest.DELTA);
    }

}
