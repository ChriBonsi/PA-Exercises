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
     * @return the number of received shots.
     */
    int shots();

    /**
     * Returns how many life-points the ship has left.
     *
     * @return the remaining life points.
     */
    int strength();

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

    /**
     * Returns the result of a received shot in the given position.
     * @param p the position to hit
     * @return the result of the shot.
     */
    ShotResult hitAt(FieldPosition p);

    /**
     * Returns the status of the ship in the given position.
     * @param p the position of the ship
     * @return the status of the ship.
     */
    ShotResult status(FieldPosition p);
}
