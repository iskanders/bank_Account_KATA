package behaviors;

import com.BankAccount.Kata.domain.Account;
import com.BankAccount.Kata.domain.AccountOperation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class checkOperation {

    Account account;
    private PrintStream printer = mock(PrintStream.class);

    @Given("A valid account with an empty operations")
    public void aValidAccountWithAnEmptyOperations() {
        List<AccountOperation> operations = new ArrayList<>();
        account = new Account(operations);
    }

    @When("I deposit an amount of {int} euro to the account")
    public void iDepositAnAmountOfEuroToTheAccount(int amount) {
        account.deposit(amount);
    }

    @And("print the last operation")
    public void printTheLastOperation() {
        account.println(printer);
    }

    @Then("A new deposit line should be printed")
    public void aNewDepositLineShouldBePrinted() {
        InOrder inOrder = Mockito.inOrder(printer);
        inOrder.verify(printer).println("operation  |   date        |   amount  |   balance");
        inOrder.verify(printer).println("deposit    |   "+ LocalDate.now().toString() +"  |   50.0    |   50.0");
    }


    @When("I withdrawal an amount of {int} euro to the account")
    public void iWithdrawalAnAmountOfEuroToTheAccount(int amount) {
        //To avoid exception
        account.deposit(amount);

        account.withdrawal(amount);
    }

    @Then("A new withdrawal line should be printed")
    public void aNewWithdrawalLineShouldBePrinted() {
        InOrder inOrder = Mockito.inOrder(printer);
        inOrder.verify(printer).println("operation  |   date        |   amount  |   balance");
        inOrder.verify(printer).println("withdrawal |   "+ LocalDate.now().toString() +"  |   30.0    |   20.0");
        inOrder.verify(printer).println("deposit    |   "+ LocalDate.now().toString() +"  |   50.0    |   50.0");
    }
}
