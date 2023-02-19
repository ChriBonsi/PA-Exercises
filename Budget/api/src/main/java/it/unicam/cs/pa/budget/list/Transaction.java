package it.unicam.cs.pa.budget.list;

import java.util.Date;
import java.util.List;

/**
 * Representation of an activity stored in {@link Ledger}.
 */
public interface Transaction extends ElementWithID {

    /**
     * Returns the time of the transaction.
     * @return the time of the transaction.
     */
    Date getDate();

    /**
     * Sets a new value for the date.
     * @param date the new value
     */
    void setDate(Date date);

    /**
     * Returns the ID of this transaction.
     * @return the ID of this transaction.
     */
    int getTransactionID();

    /**
     * Returns the total amount of this transaction. If the returned value is a positive it's
     * an income, otherwise it's an outflow.
     *
     * @return the total amount of this transaction.
     */
    double balance();

    /**
     * Returns the list of movements involved in this transaction.
     * @return the list of movements involved in this transaction.
     */
    List<Movement> getMovements();

    /**
     * Returns the list of tags used in this transaction.
     * @return the list of tags used in this transaction.
     */
    List<Tag> getTags();

    /**
     * Returns a brief description of the transaction.
     * @return a brief description of the transaction.
     */
    String getDescription();

}
