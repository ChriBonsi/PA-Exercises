package it.unicam.cs.pa.budget.list;

/**
 * A movement represents an action performed in an account.
 */
public interface Movement {

    /**
     * Returns the account involved in the movement.
     * @return the account involved in the movement.
     */
    Account getAccount();

    /**
     * Returns the amount associated to this movement.
     * @return the amount associated to this movement.
     */
    double getAmount();

    /**
     * Returns a brief description of the movement.
     * @return a brief description of the movement.
     */
    String getDescription();

    /**
     * Returns the transaction in which the movement takes part.
     * @return the transaction in which the movement takes part.
     */
    Transaction getTransaction();
}
