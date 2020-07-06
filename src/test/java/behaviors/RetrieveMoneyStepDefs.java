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
import static org.mockito.Mockito.verify;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/java/resources/retrieveMoney.feature"})
public class RetrieveMoneyStepDefs {

    Account account = BasicStepDefs.account;
    List<AccountOperation> mockedOperations = BasicStepDefs.mockedOperations;
    double retrievedAmount;

    @When("I retrieve an amount of {int} euro")
    public void iRetrieveAnAmountOfEuro(int amount) {
        retrievedAmount = amount;
        try{
            account.withdrawal(retrievedAmount);
        }catch (UnauthorizedTransactionException e){}
    }

    @When("I retrieve an amount grater than the balance")
    public void iRetrieveAnAmountGraterThanTheBalance() {
        retrievedAmount = account.getBalance()+20;
        try{
            account.withdrawal(retrievedAmount);
        }catch (UnauthorizedTransactionException e){}
    }

    @Then("A new retrieve transaction is recorded")
    public void aNewRetrieveTransactionIsRecorded() {

        verify(mockedOperations)
                .add(eq(LAST_OPERATION),any(AccountOperation.class));
    }

    @Then("A new exception is thrown")
    public void aNewExceptionIsThrown() {
        Assert.assertThrows(UnauthorizedTransactionException.class,()->account.deposit(retrievedAmount));
    }

}
