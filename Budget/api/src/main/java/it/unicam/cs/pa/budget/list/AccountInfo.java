package it.unicam.cs.pa.budget.list;

public record AccountInfo(AccountType type, String name, double openingBalance, String description) {

    public AccountInfo {
        if (!type.isValidOpening(openingBalance)) {
            throw new IllegalArgumentException("Invalid opening balance for account of type " + type);
        }
    }
}
