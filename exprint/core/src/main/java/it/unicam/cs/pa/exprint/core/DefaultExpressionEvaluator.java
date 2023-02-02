package it.unicam.cs.pa.exprint.core;

/**
 * This class provides the default implementation for an expression evaluator.
 */
public class DefaultExpressionEvaluator implements ExpressionEvaluator {

    @Override
    public double eval(Expression expression) {

        return switch (expression) {
            case SumExpression sumExpression -> evalSumExpression(sumExpression);
            case DiffExpression diffExpression -> evalDiffExpression(diffExpression);
           /* case MultExpression multExpression -> evalMultExpression(multExpression);
            case DivExpression divExpression -> evalDivExpression(divExpression);
            case LiteralExpression literalExpression ->*/
        };

        if (expression instanceof SumExpression sumExpression) {
            return eval(sumExpression.getLeftExpression()) + eval(sumExpression.getRightExpression());
        }
        return 0;
    }

    private int evalDiffExpression(DiffExpression diffExpression) {
        return 0;
    }

    private int evalSumExpression(SumExpression sumExpression) {
        return 0;
    }
}
