package it.unicam.cs.pa.budget.list;

import java.util.List;

/**
 * A Ledger is a book or collection of accounts in which account transactions are stored.
 */
public interface Ledger {

    /**
     * Returns the list of transactions recorded in this ledger.
     * @return the list of transactions recorded in this ledger.
     */
    List<Transaction> getTransactions();

    /**
     * Returns the list of accounts in this ledger.
     * @return the list of accounts in this ledger.
     */
    List<Account> getAccounts();

    /**
     * Returns the list of tags used in this ledger.
     * @return the list of tags used in this ledger.
     */
    List<Tag> getTags();

    /**
     * Returns the balance of the transactions recorded in the ledger.
     * @return the balance of the transactions recorded in the ledger.
     */
    double getTotalBalance();

    /**
     * Returns the total assets.
     * @return the total assets.
     */
    double getTotalAssets();

    /**
     * Returns the total liabilities.
     * @return the total liabilities.
     */
    double getTotalLiabilities();
}
