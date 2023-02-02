package it.unicam.cs.pa.exprint.core;

/**
 * This interface represents objects that aare used to evaluate an expression.
 */
public interface ExpressionEvaluator {

    /**
     * Method used to evaluate an expression.
     *
     * @param expression the expression to evaluate
     * @return the result of the evaluated expression.
     */
    double eval(Expression expression);
}
