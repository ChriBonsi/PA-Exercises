package it.unicam.cs.pa.budget.list;

import java.util.List;

/**
 * Represents a statement of transactions during a period and the resulting balance.
 */
public interface Account extends ElementWithId {

    /**
     * Returns the account type.
     *
     * @return the account type.
     */
    AccountType getAccountType();

    /**
     * Returns the account name.
     *
     * @return the account name.
     */
    String getAccountName();

    /**
     * Returns a short description identifying the account.
     *
     * @return a short description identifying the account.
     */
    String getDescription();

    /**
     * Returns the list of movements recorded in this account.
     *
     * @return the list of movements recorded in this account.
     */
    List<Movement> getMovements();

    /**
     * Returns the opening balance for this account.
     *
     * @return the opening balance for this account.
     */
    double getOpeningBalance();

    /**
     * Returns the opening balance.
     *
     * @param openingBalance the opening balance.
     * @throws IllegalArgumentException when <code>!getAccountType().isValidOpening(amount)</code>.
     */
    void setOpeningBalance(double openingBalance);

    /**
     * Returns the current balance for this account.
     *
     * @return the current balance for this account.
     */
    double getBalance();

    /**
     * Sets the description of this account.
     *
     * @param description the description of this account.
     */
    void setDescription(String description);


    /**
     * Sets the name of this account.
     *
     * @param name sets name of this account.
     */
    void setName(String name);
}
