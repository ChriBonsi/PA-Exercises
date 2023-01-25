package it.unicam.cs.pa.battleship;

/**
 * Used to track the attacks.
 */
public interface AttackField {

    /**
     * Sets the result in the given position
     * @param p position of the attack
     * @param result result of the attack
     */
    void set(FieldPosition p, ShotResult result);

    /**
     * Returns the value of the given position.
     * @param p the position
     * @return the value of the given position, <code>null</code> if the position hasn't been used
     */
    ShotResult get(FieldPosition p);
}
