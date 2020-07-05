package behaviors;


import com.BankAccount.Kata.Exceptions.UnauthorizedTransactionException;
import com.BankAccount.Kata.domain.Account;
import com.BankAccount.Kata.domain.AccountOperation;
import com.BankAccount.Kata.domain.Transaction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.verify;

@CucumberContextConfiguration
@RunWith(MockitoJUnitRunner.class)
public class SaveMoneySetpdefs {
    @Mock
    private List<AccountOperation> mockedOperations;
    private Account account;
    double depositAmount;

    @Given("^A valid account$")
    public void aValidAccount() {
        MockitoAnnotations.initMocks(this);
        account = new Account(mockedOperations);
    }

    @When("^I deposit an amount of (\\d+) euro$")
    public void iDepositAnAmountOfEuro(int amount) {
        depositAmount = amount;
        account.deposit(depositAmount);
    }

    @Then("^A new transaction is recorded$")
    public void aNewTransactionIsRecorded() {
        LocalDate depositDate = LocalDate.now();
        verify(mockedOperations)
                .add(new AccountOperation(Account.DEPOSIT,new Transaction(depositAmount,depositDate),account.getBalance()));
    }



}
