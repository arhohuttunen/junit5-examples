package com.arhohuttunen;

import java.util.stream.Stream;

public class StringsProvider {
    private static Stream<String> palindromes() {
        return Stream.of("level", "madam", "saippuakivikauppias");
    }
}
