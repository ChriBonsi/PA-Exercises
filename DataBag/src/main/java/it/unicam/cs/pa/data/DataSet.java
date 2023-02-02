package it.unicam.cs.pa.data;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * A DataSet is a collection of elements that have a numeric value associated to them. The classes
 * that implement the DataSet interface will provide mechanisms to elaborate the collected data.
 *
 * @param <T> type of collected data
 */
public interface DataSet<T> {

    /**
     * This method is used to register an element with a specific value associated.
     *
     * @param element the registered element
     * @param value   the associated value
     */
    void record(T element, double value);

    /**
     * Returns the minimum value registered in the DataSet.
     *
     * @return the minimum value registered in the DataSet
     */
    double min();

    /**
     * Returns the minimum value registered in the DataSet for the element.
     *
     * @param element
     * @return the minimum value registered in the DataSet for the element
     */
    double min(T element);

    /**
     * Returns the maximum value registered in the DataSet.
     *
     * @return the maximum value registered in the DataSet
     */
    double max();

    /**
     * Returns the maximum value registered in the DataSet for the element.
     *
     * @param element the element to confront
     * @return the maximum value registered in the DataSet for the element
     */
    double max(T element);

    /**
     * Returns the maximum value registered in the DataSet that satisfies the condition of the predicate.
     *
     * @param p the condition to satisfy
     * @return the maximum registered value that satisfies the predicate:
     */
    double max(Predicate<T> p);

    /**
     * Returns the minimum value registered in the DataSet that satisfies the condition of the predicate.
     *
     * @param p the condition to satisfy
     * @return the minimum registered value that satisfies the predicate:
     */
    double min(Predicate<T> p);

    /**
     * Returns the sum of all registered elements.
     *
     * @return the sum of all registered elements.
     */
    double sum();

    /**
     * Returns the sum of all registered elements that satisfy the given condition.
     *
     * @param p the condition to satisfy
     * @return the sum of all selected elements.
     */
    double sum(Predicate<T> p);

    <R> DataSet<R> map(Function<T, R> f);

    String toString(Function<? super T, ? extends String> repr);
}
