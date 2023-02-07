package it.unicam.cs.pa.exprint.core;

import java.util.Map;

/**
 * This class provides the default implementation for a double expression evaluator.
 */
public class SimpleExpressionEvaluator<T> implements ExpressionEvaluator<T> {
    private final EvaluationDomain<T> domain;
    private final Map<String, T> store;

    public SimpleExpressionEvaluator(EvaluationDomain<T> domain, Map<String, T> store) {
        this.domain = domain;
        this.store = store;
    }

    @Override
    public T eval(Expression expression) {

        return switch (expression) {
            case SumExpression sumExpression -> evalSumExpression(sumExpression);
            case DiffExpression diffExpression -> evalDiffExpression(diffExpression);
            case MultExpression multExpression -> evalMultExpression(multExpression);
            case DivExpression divExpression -> evalDivExpression(divExpression);
            case LiteralExpression literalExpression -> evalLiteralExpression(literalExpression);
            case VarExpression varExpression -> evalVarExpression(varExpression);
        };

    }

    private T evalSumExpression(SumExpression sumExpression) {
        return domain.evalSum(eval(sumExpression.leftExpression()), eval(sumExpression.rightExpression()));
    }

    private T evalDiffExpression(DiffExpression diffExpression) {
        return domain.evalDiff(eval(diffExpression.leftExpression()), eval(diffExpression.rightExpression()));
    }

    private T evalMultExpression(MultExpression multExpression) {
        return domain.evalMult(eval(multExpression.leftExpression()), eval(multExpression.rightExpression()));
    }

    private T evalDivExpression(DivExpression divExpression) {
        return domain.evalDiv(eval(divExpression.leftExpression()), eval(divExpression.rightExpression()));
    }

    private T evalLiteralExpression(LiteralExpression literalExpression) {
        return domain.evalLiteral(literalExpression.value());
    }

    private T evalVarExpression(VarExpression varExpression) {
        return store.getOrDefault(varExpression.variable(), domain.valueForUndefinedVariables());
    }
}
