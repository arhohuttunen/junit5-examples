package com.arhohuttunen.junit5.exception;

public class BankAccount {

    private Integer balance;

    BankAccount(Integer initialBalance) {
        balance = initialBalance;
    }

    public Integer withdraw(Integer amount) {
        if (balance < amount) {
            throw new NotEnoughFundsException(amount, balance);
        }
        balance -= amount;
        return balance;
    }
}
