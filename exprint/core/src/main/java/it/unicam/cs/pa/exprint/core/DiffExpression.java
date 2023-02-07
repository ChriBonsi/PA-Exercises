package it.unicam.cs.pa.exprint.core;

import java.util.Objects;

/**
 * This expression is used to model the subtraction of two expressions.
 */
public record DiffExpression(Expression leftExpression, Expression rightExpression) implements Expression {

    /**
     * Constructs a new expression that subtracts the two given arguments. A {@link NullPointerException} is
     * thrown if one of the two parameters is <code>null</code>.
     *
     * @param leftExpression  first argument of the subtraction
     * @param rightExpression second argument of the subtraction
     */
    public DiffExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = Objects.requireNonNull(leftExpression);
        this.rightExpression = Objects.requireNonNull(rightExpression);
    }
}
