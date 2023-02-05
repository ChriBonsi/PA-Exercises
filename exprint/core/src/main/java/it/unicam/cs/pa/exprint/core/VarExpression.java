package it.unicam.cs.pa.exprint.core;

import java.util.Objects;

/**
 * Instances of this class are used to model an expression consisting of a single variable.
 */
public record VarExpression(String variable) implements Expression {

    /**
     * Creates an expression consisting of a single variable.
     *
     * @param variable the given value of the variable
     */
    public VarExpression(String variable) {
        this.variable = Objects.requireNonNull(variable);
    }

}
