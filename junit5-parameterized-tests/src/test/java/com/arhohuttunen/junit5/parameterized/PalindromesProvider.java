package com.arhohuttunen.junit5.parameterized;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.ParameterDeclarations;

import java.util.stream.Stream;

public class PalindromesProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ParameterDeclarations parameterDeclarations, ExtensionContext context) {
        return Stream.of("level", "madam", "saippuakivikauppias").map(Arguments::of);
    }
}
