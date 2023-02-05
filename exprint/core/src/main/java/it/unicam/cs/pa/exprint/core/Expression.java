package it.unicam.cs.pa.exprint.core;

/**
 * This interface models a generic expression.
 */
public sealed interface Expression permits DiffExpression, DivExpression, LiteralExpression, MultExpression, SumExpression, VarExpression {
}
