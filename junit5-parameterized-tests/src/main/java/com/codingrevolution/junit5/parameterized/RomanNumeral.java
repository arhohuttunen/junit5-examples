package com.codingrevolution.junit5.parameterized;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeral {

    private static Map<Integer, String> NUMERALS;

    static {
        NUMERALS = new LinkedHashMap<>();
        NUMERALS.put(50, "L");
        NUMERALS.put(40, "XL");
        NUMERALS.put(10, "X");
        NUMERALS.put(9, "IX");
        NUMERALS.put(5, "V");
        NUMERALS.put(4, "IV");
        NUMERALS.put(1, "I");
    }

    private String numeral = "";

    public RomanNumeral(int number) {
        for (Integer arabic : NUMERALS.keySet()) {
            while (number >= arabic) {
                numeral += NUMERALS.get(arabic);
                number -= arabic;
            }
        }
    }

    @Override
    public String toString() {
        return numeral;
    }
}
