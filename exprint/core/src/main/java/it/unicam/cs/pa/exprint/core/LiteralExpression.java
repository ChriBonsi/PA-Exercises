package it.unicam.cs.pa.exprint.core;

import java.util.Objects;

/**
 * Instances of this class are used to model an expression consisting of literal values.
 */
public record LiteralExpression(Number value) implements Expression{

    /**
     * Contstructs a new literal expression with the given value.
     *
     * @param value the given value
     */
    public LiteralExpression(Number value) {
        this.value = Objects.requireNonNull(value);
    }
}
