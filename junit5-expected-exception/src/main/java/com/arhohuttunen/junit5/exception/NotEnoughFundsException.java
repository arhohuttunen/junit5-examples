package com.arhohuttunen.junit5.exception;

public class NotEnoughFundsException extends RuntimeException {
    public NotEnoughFundsException(Integer amount, Integer balance) {
        super("Attempted to withdraw " + amount + " with a balance of " + balance);
    }
}
