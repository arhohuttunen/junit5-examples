package com.codingrevolution.junit5.parameterized;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.TypedArgumentConverter;

class HexConverter extends TypedArgumentConverter<String, Integer> {

    protected HexConverter() {
        super(String.class, Integer.class);
    }

    @Override
    public Integer convert(String source)
            throws ArgumentConversionException {
        try {
            return Integer.parseInt(source, 16);
        } catch (NumberFormatException e) {
            throw new ArgumentConversionException("Cannot convert hex value", e);
        }
    }
}
