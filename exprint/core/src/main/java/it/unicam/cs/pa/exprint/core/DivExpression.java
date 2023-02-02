package it.unicam.cs.pa.exprint.core;

import java.util.Objects;

/**
 * Instances of this class are used to model a division between expressions .
 */
public class DivExpression {

    private final Expression leftExpression;
    private final Expression rightExpression;

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

    /**
     * Returns the first argument of the division.
     *
     * @return the first argument of the division.
     */
    public Expression getLeftExpression() {
        return leftExpression;
    }

    /**
     * Returns the second argument of the division.
     *
     * @return the second argument of the division.
     */
    public Expression getRightExpression() {
        return rightExpression;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DivExpression that = (DivExpression) o;
        return getLeftExpression().equals(that.getLeftExpression()) && getRightExpression().equals(that.getRightExpression());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLeftExpression(), getRightExpression());
    }
}
