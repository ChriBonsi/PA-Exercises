package it.unicam.cs.pa.budget.list;

import java.util.List;

/**
 * Represents a statement of transactions during a period and the resulting balance.
 */
public interface Account {

    /**
     * Returns the type of the account.
     * @return the type of the account.
     */
    AccountType getAccountType();

    /**
     * Returns an integer that identifies distinctively the account.
     * @return an integer that identifies distinctively the account.
     */
    int getAccountID();

    /**
     * Returns the name of the account.
     * @return the name of the account.
     */
    String getAccountName();

    /**
     * Returns a brief description of the account.
     * @return a brief description of the account.
     */
    String getDescription();

    /**
     * Returns a list of the movements recorded in this account.
     * @return a list of the movements recorded in this account.
     */
    List<Movement> getMovements();

    /**
     * Returns the opening balance of the account.
     * @return the opening balance of the account.
     */
    double getOpeningBalance();

    /**
     * Returns the current balance of the account.
     * @return the current balance of the account.
     */
    double getBalance();
}
