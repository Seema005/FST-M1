package JUNIT;

import Activities.BankAccount;
import Activities.NotEnoughFundsException;
import org.junit.jupiter.api.Test;
        import static org.junit.jupiter.api.Assertions.assertThrows;
        import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class Activity2 {
    @Test
    void notEnoughFunds() {
        // Create an object for BankAccount class with balance 9
        BankAccount account = new BankAccount(9);

        // Assertion for exception
        assertThrows(NotEnoughFundsException.class, () -> account.withdraw(10));
    }

    @Test
    void enoughFunds() {
        // Create an object for BankAccount class with balance 100
        BankAccount account = new BankAccount(100);

        // Assertion for no exceptions
        assertDoesNotThrow(() -> account.withdraw(100));
    }
}
