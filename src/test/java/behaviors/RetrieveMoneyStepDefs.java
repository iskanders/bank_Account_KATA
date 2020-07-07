package behaviors;

import com.BankAccount.Kata.Exceptions.UnauthorizedTransactionException;
import com.BankAccount.Kata.domain.Account;
import com.BankAccount.Kata.domain.AccountOperation;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Assert;
import org.junit.runner.RunWith;
import java.util.List;

import static com.BankAccount.Kata.domain.Account.LAST_OPERATION;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class RetrieveMoneyStepDefs {

    Account account = BasicStepDefs.account;
    List<AccountOperation> mockedOperations = BasicStepDefs.mockedOperations;
    double retrievedAmount;


    @When("I retrieve an amount of {int} euro")
    public void iRetrieveAnAmountOfEuro(int amount) {
        // Add an amount of money to the account to avoid exception.
        account.deposit(50);

        retrievedAmount = amount;
        try{
            account.withdrawal(retrievedAmount);
        }catch (UnauthorizedTransactionException e){
        }
    }

    @When("I retrieve an amount grater than the balance")
    public void iRetrieveAnAmountGraterThanTheBalance() {
        retrievedAmount = account.getBalance()+20;
    }

    @Then("A new retrieve transaction is recorded")
    public void aNewRetrieveTransactionIsRecorded() {

        // 2 times : 1 for the deposit
        //           1 for the withdrawal
        verify(mockedOperations,times(2))
                .add(eq(LAST_OPERATION),any(AccountOperation.class));
    }

    @Then("A new exception is thrown")
    public void aNewExceptionIsThrown() {
        Assert.assertThrows(UnauthorizedTransactionException.class,()->account.withdrawal(retrievedAmount));
    }

}
