package com.BankAccount.Kata;

import com.BankAccount.Kata.domain.Transaction;
import org.junit.Before;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;

@SpringBootTest
public class BaseTest {

    public final static double DELTA = 0.00001;

    public Transaction transaction;

    @Before
    public void init(){
        transaction=new Transaction(50, LocalDate.now());
    }

}
