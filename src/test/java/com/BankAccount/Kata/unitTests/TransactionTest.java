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
        LocalDateTime currentDate = LocalDateTime.now();
        transaction = new Transaction(50, currentDate);
        double balance = transaction.execute(2500.20);
        Assert.assertEquals(balance,2550.20, BaseTest.DELTA);
    }

    @Test
    public void valideequalsTest(){
        LocalDateTime currentDate = LocalDateTime.now();
        transaction = new Transaction(20,currentDate);
        Transaction transaction1 = new Transaction(20,currentDate);
        Assert.assertTrue(transaction.equals(transaction1));
    }

    @Test
    public void InvalideequalsTest(){
        LocalDateTime currentDate = LocalDateTime.now();
        transaction = new Transaction(20,currentDate);
        Transaction transaction2 = new Transaction(30, LocalDateTime.now());
        Assert.assertFalse(transaction.equals(transaction2));
    }


}