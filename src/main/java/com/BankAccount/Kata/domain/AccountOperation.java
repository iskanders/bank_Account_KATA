package com.BankAccount.Kata.domain;

/**
 * Account operation class represents a line in the history
 * of operations of an account.
 *
 * Each line contains the name of the operation, the transaction
 * and the balance.
 *
 * It uses Lombok to create constructors and to implement builder design pattern
 *
 * */
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.PrintStream;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class AccountOperation {

    private String operationName;
    private Transaction transaction;
    private double balance;

    public void setBalance(double balance) {
        this.balance = balance;
    }


    /**
     * Compares the argument to the receiver, and answers true
     * if they represent the same transaction using a class
     * specific comparison. The implementation in transaction answers
     * true only if the argument is the exact same object as the
     * receiver (equals).
     *
     * @param		object Object
     *					the operation to compare with this operation.
     * @return		boolean
     *					true
     *						if the operation name equal to this operation name and
     *					    the operation transaction is equal to this transaction and
     *					    the operation balance is equal to this balance
     *					false
     *						if it is different from this object.
     */
    @Override
    public boolean equals (Object object){
        if (this == object)
            return true;
        AccountOperation externOperation = (AccountOperation) object;
        if(transaction==null)
            if(externOperation.getTransaction()!=null)
                return false;
        if(operationName==null)
            if(externOperation.getOperationName()!=null)
                return false;
        if(operationName.equals(externOperation.getOperationName())
                && transaction.equals(externOperation.getTransaction())
                && balance == externOperation.getBalance()) return true;
        return false;
    }


    /**
     * Answers a string containing a concise, human-readable
     * description of this operation.
     *
     * @return		String
     *					the name of this operation.
     */
    @Override
    public String toString(){return operationName;}

    public void println(PrintStream printer){

        StringBuilder builder = new StringBuilder();
        builder.append(this.operationName);
        if(operationName.equals(Account.DEPOSIT)) builder.append("    | ");
        else builder.append(" | ");
        builder.append(this.transaction.getTransactionDate());
        builder.append("    | ");
        builder.append(this.transaction.getValue());
        builder.append("      | ");
        builder.append(this.balance);

        printer.println(builder.toString());
    }
}
