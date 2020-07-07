package com.BankAccount.Kata.unitTests;


import com.BankAccount.Kata.BaseTest;
import com.BankAccount.Kata.domain.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RunWith(MockitoJUnitRunner.class)
public class TransactionTest {

    Transaction transaction;

    @Test
    public void executeTest(){
        LocalDate currentDate = LocalDate.now();
        transaction = new Transaction(50, currentDate);
        double balance = transaction.execute(2500.20);
        Assert.assertEquals(balance,2550.20, BaseTest.DELTA);
    }

}