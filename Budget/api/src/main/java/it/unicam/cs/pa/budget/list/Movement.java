package it.unicam.cs.pa.budget.list;

/**
 * A movement represents an operation performed over an account.
 *
 * @param account account involved in the movement.
 * @param amount the amount of the movement.
 * @param description a short description of the movement.
 */
public record Movement(Account account, double amount, String description) {

}
