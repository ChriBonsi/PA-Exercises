package it.unicam.cs.pa.exprint.core;

import java.util.Objects;

/**
 * This expression is used to model the subtraction of two expressions.
 */
public class DiffExpression {

    private final Expression leftExpression;
    private final Expression rightExpression;

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

    /**
     * Returns the first argument of the subtraction.
     *
     * @return the first argument of the subtraction.
     */
    public Expression getLeftExpression() {
        return leftExpression;
    }

    /**
     * Returns the second argument of the subtraction.
     *
     * @return the second argument of the subtraction.
     */
    public Expression getRightExpression() {
        return rightExpression;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiffExpression that = (DiffExpression) o;
        return getLeftExpression().equals(that.getLeftExpression()) && getRightExpression().equals(that.getRightExpression());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLeftExpression(), getRightExpression());
    }
}
