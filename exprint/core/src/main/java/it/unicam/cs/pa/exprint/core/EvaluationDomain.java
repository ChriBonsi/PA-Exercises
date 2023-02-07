package it.unicam.cs.pa.exprint.core;

public interface EvaluationDomain<T> {

    T evalLiteral(Number n);

    T evalSum(T arg1, T arg2);

    T evalDiff(T arg1, T arg2);

    T evalDiv(T arg1, T arg2);

    T evalMult(T arg1, T arg2);

    T valueForUndefinedVariables();
}
