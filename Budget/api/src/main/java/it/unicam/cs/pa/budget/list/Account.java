package it.unicam.cs.pa.budget.list;

/**
 * Represents a statement of transactions during a period and the resulting balance.
 */
public interface Account {

    /**
     * Returns the type of the account.
     * @return the type of the account.
     */
    AccountType getAccuntType();

    /**
     * Returns an integer that identifies univocally the account.
     * @return an integer that identifies univocally the account.
     */
    int getAccountID();
}
