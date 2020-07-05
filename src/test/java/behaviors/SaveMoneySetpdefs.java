package behaviors;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SaveMoneySetpdefs {
    
    @Given("^A valid account$")
    public void aValidAccount() {
    }

    @When("^I deposit an amount of (\\d+) euro$")
    public void iDepositAnAmountOfEuro(int amount) {
    }

    @Then("^A new transaction is recorded$")
    public void aNewTransactionIsRecorded() {
    }

}
