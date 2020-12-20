package com.arhohuttunen.junit5.parameterized;

public class StringUtils {
    public static boolean isPalindrome(String word) {
        return new StringBuilder(word).reverse().toString().equals(word);
    }
}
