package com.BankAccount.Kata;

import com.BankAccount.Kata.domain.Account;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class KataApplication {

	public static void main(String[] args) {
		Account account = new Account(new ArrayList<>());

		account.deposit(50);
		account.deposit(20);
		account.withdrawal(10);

		account.println(System.out);
	}

}
