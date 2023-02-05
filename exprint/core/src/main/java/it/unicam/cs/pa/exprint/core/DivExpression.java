package it.unicam.cs.pa.exprint.core;

import java.util.Objects;

/**
 * Instances of this class are used to model a division between expressions .
 */
public record DivExpression(Expression leftExpression, Expression rightExpression) implements Expression{

    /**
     * Constructs a new expression that divides the two given arguments. A {@link NullPointerException} is
     * thrown if one of the two parameters is <code>null</code>.
     *
     * @param leftExpression  first argument of the division
     * @param rightExpression second argument of the division
     */
    public DivExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = Objects.requireNonNull(leftExpression);
        this.rightExpression = Objects.requireNonNull(rightExpression);
    }
}
