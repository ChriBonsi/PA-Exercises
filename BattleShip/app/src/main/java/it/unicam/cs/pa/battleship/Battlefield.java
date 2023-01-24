package it.unicam.cs.pa.battleship;

/**
 * This interface represents a generic battlefield.
 */
public interface Battlefield {

    /**
     * Adds a new ship on the battlefield starting from the coordinates towards the specified direction.
     * @param ship the ship
     * @param row the row of the coordinates
     * @param column the column of the coordinates
     * @param dir the direction of the ship
     * @return true if the ship is successfully added, false otherwise.
     */
    boolean addship(Ship ship, int row, int column, Direction dir);

    /**
     * Adds a new ship on the battlefield starting from the coordinates towards the default direction.
     * @param ship the ship
     * @param row the row of the coordinates
     * @param column the column of the coordinates
     * @return true if the ship is successfully added, false otherwise.
     */
    default boolean addship(Ship ship, int row, int column) {
        return addship(ship, row, column, Direction.NORTH);
    };


    /**
     * Shoot at the specified position.
     * @param row the shot row
     * @param column the shot column
     * @return the result of the shot.
     */
    ShotResult shootAt(int row, int column);

    /**
     * Checks if there's a ship in the specified location.
     * @param row the row to check
     * @param column the column to check
     * @return the ship in the location, null otherwise.
     */
    Ship shipAt(int row, int column);

    /**
     * Checks if the specified location contains a ship.
     * @param row the row of the location
     * @param column the column of the location
     * @return true if the location has no ship, false otherwise.
     */
    default boolean isFree(int row, int column){
        return shipAt(row, column) == null;
    };

    /**
     * @return the width of the battlefield.
     */
    int width();

    /**
     * @return the height of the battlefield.
     */
    int height();

    ShotResult status(int row, int column);

}
