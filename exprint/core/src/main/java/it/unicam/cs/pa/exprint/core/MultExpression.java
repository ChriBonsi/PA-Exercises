package it.unicam.cs.pa.exprint.core;

import java.util.Objects;

/**
 * This expression is used to model the multiplication of two expressions.
 */
public record MultExpression(Expression leftExpression, Expression rightExpression) implements Expression {

    /**
     * Constructs a new expression that multiplies the two given arguments. A {@link NullPointerException} is
     * thrown if one of the two parameters is <code>null</code>.
     *
     * @param leftExpression  first argument of the multiplication
     * @param rightExpression second argument of the multiplication
     */
    public MultExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = Objects.requireNonNull(leftExpression);
        this.rightExpression = Objects.requireNonNull(rightExpression);
    }
}
