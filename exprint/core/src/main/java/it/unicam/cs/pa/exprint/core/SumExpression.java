package it.unicam.cs.pa.exprint.core;

import java.util.Objects;

/**
 * This expression is used to model the sum of two expressions.
 */
public record SumExpression(Expression leftExpression, Expression rightExpression) implements Expression {

    /**
     * Constructs a new expression that sums the two given arguments. A {@link NullPointerException} is
     * thrown if one of the two parameters is <code>null</code>.
     *
     * @param leftExpression  first argument of the sum
     * @param rightExpression second argument of the sum
     */
    public SumExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = Objects.requireNonNull(leftExpression);
        this.rightExpression = Objects.requireNonNull(rightExpression);
    }
}
