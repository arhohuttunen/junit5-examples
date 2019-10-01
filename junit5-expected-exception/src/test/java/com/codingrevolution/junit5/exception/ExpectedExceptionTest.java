package com.codingrevolution.junit5.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpectedExceptionTest {

    @Test
    void notEnoughFunds() {
        BankAccount account = new BankAccount(9);

        assertThrows(NotEnoughFundsException.class, () -> account.withdraw(10),
                "Balance must be greater than amount of withdrawal");
    }

    @Test
    void notEnoughFundsWithMessage() {
        BankAccount account = new BankAccount(0);

        Throwable thrown = assertThrows(NotEnoughFundsException.class, () -> account.withdraw(100));

        assertEquals("Attempted to withdraw 100 with a balance of 0", thrown.getMessage());
    }

    @Test
    void enoughFunds() {
        BankAccount account = new BankAccount(100);

        assertDoesNotThrow(() -> account.withdraw(100));
    }
}
