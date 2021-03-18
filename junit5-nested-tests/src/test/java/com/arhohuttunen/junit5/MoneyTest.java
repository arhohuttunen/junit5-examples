package com.arhohuttunen.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoneyTest {
    @Nested
    @DisplayName("equality is based on values")
    class Equality {
        @Test
        @DisplayName("monies with same amounts are equal")
        void moniesWithSameAmountsAreEqual() {
            CurrencyUnit eur = CurrencyUnit.of("EUR");
            Money first = Money.of(eur, 3.99);
            Money second = Money.of(eur, 3.99);

            assertEquals(second, first);
        }

        @Test
        @DisplayName("monies with different amounts are not equal")
        void moniesWithDifferentAmountsAreNotEqual() {
            CurrencyUnit eur = CurrencyUnit.of("EUR");
            Money first = Money.of(eur, 3.99);
            Money second = Money.of(eur, 3.89);

            assertNotEquals(second, first);
        }

        @Test
        @DisplayName("monies with different currencies are not equal")
        void moniesWithDifferentCurrenciesAreNotEqual() {
            CurrencyUnit eur = CurrencyUnit.of("EUR");
            CurrencyUnit usd = CurrencyUnit.of("USD");
            Money first = Money.of(eur, 3.99);
            Money second = Money.of(usd, 3.99);

            assertNotEquals(second, first);
        }
    }

    @Nested
    @DisplayName("adding monetary amounts")
    class Adding {
        @Test
        @DisplayName("can add monies of same currency")
        void addMoneyWithSameCurrency() {
            CurrencyUnit eur = CurrencyUnit.of("EUR");
            Money money = Money.of(eur, 4.25);
            Money addend = Money.of(eur, 1.4);

            Money sum = money.add(addend);

            assertEquals(BigDecimal.valueOf(5.65), sum.getAmount());
        }

        @Test
        @DisplayName("cannot add monies of different currency")
        void addMoneyWithDifferentCurrency() {
            CurrencyUnit eur = CurrencyUnit.of("EUR");
            CurrencyUnit usd = CurrencyUnit.of("USD");
            Money money = Money.of(eur, 4.25);
            Money addend = Money.of(usd, 1.4);

            assertThrows(CurrencyMismatchException.class, () -> money.add(addend));
        }
    }
}
