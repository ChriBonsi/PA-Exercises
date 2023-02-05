package it.unicam.cs.pa.exprint.core;

/**
 * This class provides the default implementation for an expression evaluator.
 */
public class DefaultExpressionEvaluator implements ExpressionEvaluator<Double> {

    @Override
    public Double eval(Expression expression) {

        return switch (expression) {
            case SumExpression sumExpression -> evalSumExpression(sumExpression);
            case DiffExpression diffExpression -> evalDiffExpression(diffExpression);
           case MultExpression multExpression -> evalMultExpression(multExpression);
            case DivExpression divExpression -> evalDivExpression(divExpression);
            case LiteralExpression literalExpression -> evalLiteralExpression(literalExpression);
            case VarExpression varExpression -> evalVarExpression(varExpression);
        };

    }

    private double evalSumExpression(SumExpression sumExpression) {
        return eval(sumExpression.leftExpression())+eval(sumExpression.rightExpression());
    }

    private double evalDiffExpression(DiffExpression diffExpression) {
        return eval(diffExpression.leftExpression())-eval(diffExpression.rightExpression());
    }

    private double evalMultExpression(MultExpression multExpression) {
        return eval(multExpression.leftExpression())*eval(multExpression.rightExpression());
    }

    private double evalDivExpression(DivExpression divExpression) {
        return eval(divExpression.leftExpression())/eval(divExpression.rightExpression());
    }

    private double evalLiteralExpression(LiteralExpression literalExpression) {
        return 0;
    }

    private double evalVarExpression(VarExpression varExpression) {
        VarExpression v2 = new VarExpression("Ciao");
        varExpression.variable();
        return 0.0;
    }
}
