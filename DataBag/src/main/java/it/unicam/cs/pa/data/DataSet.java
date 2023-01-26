package it.unicam.cs.pa.data;

/**
 * A DataSet is a collection of elements that have a numeric value associated to them. The classes
 * that implement the DataSet interface will provide mechanisms to elaborate the collected data.
 * @param <T> type of collected data
 */
public interface DataSet<T> {

    /**
     * This method is used to register an element with a specific value associated.
     * @param element the registered element
     * @param value the associated value
     */
    void record(T element, double value);

    /**
     * Returns the minimum value registered in the DataSet.
     * @return the minimum value registered in the DataSet
     */
    double min();

    /**
     * Returns the minimum value registered in the DataSet for the element.
     * @param element
     * @return the minimum value registered in the DataSet for the element
     */
    double min(T element);


    /**
     * Returns the maximum value registered in the DataSet.
     * @return the maximum value registered in the DataSet
     */
    double max();

    /**
     * Returns the maximum value registered in the DataSet for the element.
     * @param element the element to confront
     * @return the maximum value registered in the DataSet for the element
     */
    double max(T element);

}
