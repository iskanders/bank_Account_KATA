package com.BankAccount.Kata.IntegrationTest;

import com.BankAccount.Kata.BaseTest;
import com.BankAccount.Kata.domain.Account;
import com.BankAccount.Kata.domain.AccountOperation;
import com.BankAccount.Kata.domain.Transaction;
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
        Assert.assertEquals(operation.getBalance(),account.getBalance(),BaseTest.DELTA);
    }
}
