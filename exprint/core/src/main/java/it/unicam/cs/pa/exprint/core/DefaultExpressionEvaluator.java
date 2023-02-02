package it.unicam.cs.pa.exprint.core;

/**
 * This class provides the default implementation for an expression evaluator.
 */
public class DefaultExpressionEvaluator implements ExpressionEvaluator {
    
    @Override
    public double eval(Expression expression) {
        if (expression instanceof SumExpression sumExpression) {
            return eval(sumExpression.getLeftExpression())+eval(sumExpression.getRightExpression());
        }
        return 0;
    }
}
