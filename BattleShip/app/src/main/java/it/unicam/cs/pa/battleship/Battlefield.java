package it.unicam.cs.pa.battleship;

/**
 * Interface that represents a generic battlefield.
 */
public interface Battlefield {

    /**
     * Adds a new ship on the battlefield starting from the coordinates towards the specified direction.
     *
     * @param ship   the ship
     * @param position the location (row,column) where the ship starts to be placed
     * @param dir    the direction of the ship
     * @return true if the ship is successfully added, false otherwise.
     * @throws NullPointerException if the ship is null.
     */
    boolean addShip(Ship ship, FieldPosition position, Direction dir) throws NullPointerException ;

    /**
     * Adds a new ship on the battlefield starting from the coordinates towards the default direction.
     *
     * @param ship   the ship
     * @param position the location (row,column) where the ship starts to be placed
     * @return true if the ship is successfully added, false otherwise.
     */
    default boolean addShip(Ship ship, FieldPosition position){
        return addShip(ship, position, Direction.NORTH);
    }

    /**
     * Shoot at the specified position.
     *
     * @param position the location (row,column) to shoot at
     * @return the result of the shot.
     */
    ShotResult shootAt(FieldPosition position);

    /**
     * Checks if there's a ship in the specified location.
     *
     * @param position the position (row,column) of the ship
     * @return the ship in the location, null otherwise.
     * @throws ArrayIndexOutOfBoundsException if the index are negatives or out the field limit.
     */
    Ship shipAt(FieldPosition position) throws ArrayIndexOutOfBoundsException;

    /**
     * Checks if the specified location contains a ship.
     *
     * @param position the location (row,column) to check
     * @return true if the location has no ship, false otherwise.
     */
    default boolean isFree(FieldPosition position) {
        return shipAt(position) == null;
    }

    /**
     * @return the width of the battlefield.
     */
    int width();

    /**
     * @return the height of the battlefield.
     */
    int height();

    /**
     * Checks the status of a cell.
     *
     * @param position the position (row,column) to check
     * @return the status of the cell.
     */
    Object result(FieldPosition position);

}
