package it.unicam.cs.pa.exprint.core;

import java.util.Objects;

/**
 * Instances of this class are used to model an expression consisting of a single variable.
 */
public class VarExpression {

    private final String variable;

    /**
     * Creates an expression consisting of a single variable.
     *
     * @param variable the given value of the variable
     */
    public VarExpression(String variable) {
        this.variable = Objects.requireNonNull(variable);
    }

    /**
     * Returns the value of the variable.
     *
     * @return the value of the variable.
     */
    public String getVariable() {
        return variable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VarExpression that = (VarExpression) o;
        return getVariable().equals(that.getVariable());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVariable());
    }
}
