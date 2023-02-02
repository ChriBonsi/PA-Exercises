package it.unicam.cs.pa.exprint.core;

import java.util.Objects;

/**
 * Instances of this class are used to model an expression consisting of literal values.
 */
public class LiteralExpression {

    private final Number value;

    /**
     * Contstructs a new literal expression with the given value.
     *
     * @param value the given value
     */
    public LiteralExpression(Number value) {
        this.value = Objects.requireNonNull(value);
    }

    /**
     * Returns the value occurring in the expression.
     *
     * @return the value occurring in the expression.
     */
    public Number getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LiteralExpression that = (LiteralExpression) o;
        return getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
