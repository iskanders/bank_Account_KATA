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
import java.time.LocalDateTime;
import java.util.List;
import static com.BankAccount.Kata.domain.Account.LAST_OPERATION;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;


public class SaveMoneySetpdefs{

    Account account = BasicStepDefs.account;
    List<AccountOperation> mockedOperations = BasicStepDefs.mockedOperations;
    double depositAmount;



    @When("^I deposit an amount of (\\d+) euro$")
    public void iDepositAnAmountOfEuro(int amount) {
        depositAmount = amount;
        try{
            account.deposit(depositAmount);
        }catch (UnauthorizedTransactionException e){

        }
    }

    @Then("^A new transaction is recorded$")
    public void aNewTransactionIsRecorded() {
        LocalDateTime depositDate = LocalDateTime.now();
        verify(mockedOperations)
                .add(eq(LAST_OPERATION),any(AccountOperation.class));
    }

    @Then("An exception is thrown")
    public void anExceptionIsThrown() {
        Assert.assertThrows(UnauthorizedTransactionException.class,()->account.deposit(depositAmount));
    }

}
