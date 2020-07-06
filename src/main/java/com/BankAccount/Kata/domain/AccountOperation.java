package com.BankAccount.Kata.domain;

public class AccountOperation {

    public AccountOperation(String operationName, Transaction transaction,double balance){

    }

    @Override
    public boolean equals(Object o){return false;}

    @Override
    public String toString(){return "";}

    public Transaction getTransaction(){
        return null;
    }

    public float getBalance(){
        return -1;
    }
}
