package behaviors;

/**
 * BasicStepDefs contains the common given step
 * for all scenarios.
 * It uses the mock list of operations to instance
 * the account that will be used for all scenarios.
 * */
import com.BankAccount.Kata.domain.Account;
import com.BankAccount.Kata.domain.AccountOperation;
import io.cucumber.java.en.Given;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@CucumberContextConfiguration
public class BasicStepDefs {
    @Mock
    public static List<AccountOperation> mockedOperations;
    public static Account account;

    @Given("^A valid account$")
    public void aValidAccount() {
        MockitoAnnotations.initMocks(this);
        account = new Account(mockedOperations);
    }
}
