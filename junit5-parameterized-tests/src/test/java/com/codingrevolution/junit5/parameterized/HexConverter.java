package com.codingrevolution.junit5.parameterized;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

class HexConverter implements ArgumentConverter {

    @Override
    public Object convert(Object source, ParameterContext context)
            throws ArgumentConversionException {
        try {
            return Integer.parseInt((String) source, 16);
        } catch (NumberFormatException e) {
            throw new ArgumentConversionException("Cannot convert hex value", e);
        }
    }
}
