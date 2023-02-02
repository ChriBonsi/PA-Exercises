package it.unicam.cs.pa.exprint.core;

import java.util.Objects;

/**
 * This expression is used to model the sum of two expressions.
 */
public class SumExpression implements Expression {

    private final Expression leftExpression;
    private final Expression rightExpression;

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

    /**
     * Returns the first argument of the sum.
     *
     * @return the first argument of the sum.
     */
    public Expression getLeftExpression() {
        return leftExpression;
    }

    /**
     * Returns the second argument of the sum.
     *
     * @return the second argument of the sum.
     */
    public Expression getRightExpression() {
        return rightExpression;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SumExpression that = (SumExpression) o;
        return getLeftExpression().equals(that.getLeftExpression()) && getRightExpression().equals(that.getRightExpression());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLeftExpression(), getRightExpression());
    }
}
