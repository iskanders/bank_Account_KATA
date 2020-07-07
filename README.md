# About The Project

This project is aimed to manage a bank account. It allows to deposit and withdrawal an amount of money as well as get the historic of transactions.
This project is based on behaviour-driven development (BDD) and Test-Driven Development (TDD) methods.

# Understanding the code

This Project is devided in 2 modules :

- source module
- Test module

### Source module

This module contains 3 objects type : 

- <code>Account</code> : That contains informations related to a given a bank account. It provide 3 basic operations : deposit, withdrawal and history viewing.
- <code>AccountOperation</code> : It represents one possible operation on the account object: withdrawal / deposit.
- <code>Transaction</code> : It allows to perform operations on the account object.

### Test module

This module contains  2 type of tests :

- Behaviors tests implemented by Cucumber framework. A new feature file is implemented in the <code>src/test/resources</code> folder for each user story. Furthermore, For each feature, its step definition is located in <code>src/test/java/behaviors</code>.
- Unit and integration tests implemented by JUnit5. For each method, a unit and integration test is implemented in <code>src/test/java/com.BacnkAccount.Kata</code> folder.

# Required

- **Cucumber** : To applicate BDD method
- **JUnit5** : For the unit and integration tests (TDD).
- **Maven** : To manage dependencies and project build and test.

# Instructions

1. Clone this repo.
2. In your CMD run <code>mvn clean test</code> to run all the tests of behaviors, unit and integration.
3. run the main function in the kataApplication file.


