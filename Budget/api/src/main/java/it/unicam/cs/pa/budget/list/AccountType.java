package it.unicam.cs.pa.budget.list;

/**
 * We consider two kinds of accounts: assets and liabilities.
 */
public enum AccountType {

    /**
     * Assets are resources (tangible and intangible) that your business owns,
     * and that can provide you with future economic benefit.
     */
    ASSET,

    /**
     * Liabilities are your business' debts or obligations which you need to fulfill in the future.
     */
    LIABILITY;

    public boolean isValidOpening(double amount) {
        return ((this == ASSET) && (amount >= 0)) || ((this == LIABILITY) && (amount <= 0));
    }
}
