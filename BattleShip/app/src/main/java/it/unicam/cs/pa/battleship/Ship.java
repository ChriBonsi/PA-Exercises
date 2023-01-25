package it.unicam.cs.pa.battleship;

/**
 * Interface that represents a generic ship.
 */
public interface Ship {

    /**
     * Returns the size of the ship.
     *
     * @return the size of the ship.
     */
    int size();

    /**
     * Returns the number of shots received by the ship.
     *
     * @return the nymber of received shots.
     */
    int shots();

    /**
     * Returns how many life points the ship has left.
     *
     * @return the remaining life points.
     */
    int strenght();

    /**
     * Checks if the ship has been destroyed.
     *
     * @return true if the ship has been destroyed, false otherwise.
     */
    boolean isDestroyed();

    /**
     * Returns the name of the ship as a string.
     *
     * @return the name of the ship.
     */
    String getName();
}
