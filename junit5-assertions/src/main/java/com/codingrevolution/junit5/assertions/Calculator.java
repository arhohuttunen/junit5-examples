package com.codingrevolution.junit5.assertions;

public class Calculator {

    public int add(int first, int second) {
        return first + second;
    }

    public int divide(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return numerator / denominator;
    }

    public double square(double number) {
        return number * number;
    }
}
