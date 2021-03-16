package com.arhohuttunen.junit5;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {
    private final CurrencyUnit currency;
    private final BigDecimal amount;

    private Money(CurrencyUnit currency, BigDecimal amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public static Money of(CurrencyUnit currency, Double amount) {
        return new Money(currency, new BigDecimal(amount).setScale(2, RoundingMode.HALF_UP));
    }

    public Money add(Money money) {
        if (!currency.equals(money.currency)) {
            throw new CurrencyMismatchException();
        }
        return new Money(currency, amount.add(money.amount));
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(currency, money.currency) && Objects.equals(amount, money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, amount);
    }
}
