package it.unicam.cs.pa.battleship;

/**
 * Default representation of the battlefield.
 */
public class DefaultBattlefield implements Battlefield {

    private static final int DEFAULT_SIZE = 10;
    private static final int DEFAULT_WIDTH = DEFAULT_SIZE;
    private static final int DEFAULT_HEIGHT = DEFAULT_SIZE;
    private final Ship[][] field;
    private boolean[][] positionFlag;
    private final int width;
    private final int height;

    /**
     * Creates a battlefield with default dimensions.
     */
    public DefaultBattlefield() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    /**
     * Creates a battlefield with given dimensions.
     *
     * @param width  the width of the battlefield
     * @param height the height of the battlefield
     */
    public DefaultBattlefield(int width, int height) {
        this.field = new Ship[width][height];
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean addShip(Ship ship, FieldPosition p, Direction dir) {
        FieldPosition[] positions = dir.computePositions(p.getRow(), p.getColumn(), ship.size());
        if (!checkPositions(positions)) {
            return false;
        }
        addShip(ship, positions);
        return true;
    }

    private void addShip(Ship ship, FieldPosition[] positions) {
        for (FieldPosition p : positions) {
            this.field[p.getRow()][p.getColumn()] = ship;
        }
    }

    /*
     * Checks if all the given positions are valid in the field.
     */
    private boolean checkPositions(FieldPosition[] positions) {
        for (FieldPosition p : positions) {
            if (!checkPosition(p)) {
                return false;
            }
        }
        return true;
    }

    /*
     * Checks if the given position is valid in the field.
     */
    private boolean checkPosition(FieldPosition p) {
        if (p.getColumn() < 0 || p.getColumn() >= width() || p.getRow() < 0 || p.getRow() >= height()) return false;
        return isFree(p);
    }

    @Override
    public ShotResult shootAt(FieldPosition p) {
        Ship ship = shipAt(p);
        recordShotAt(p);
        if (ship == null) {
            return ShotResult.MISSED;
        } else return ship.hitAt(p);
    }

    private void recordShotAt(FieldPosition p) {
        positionFlag[p.getRow()][p.getColumn()] = true;

    }

    @Override
    public Ship shipAt(FieldPosition p) {
        return this.field[p.getRow()][p.getColumn()];
    }

    @Override
    public int width() {
        return this.width;
    }

    @Override
    public int height() {
        return this.height;
    }

    @Override
    public ShotResult result(FieldPosition p) {
        if (hasBeenUsed(p)) {
            Ship ship = shipAt(p);
            if (ship == null) return ShotResult.MISSED;
            else return ship.status(p);
        }

        return null;
    }

    private boolean hasBeenUsed(FieldPosition p) {
        return this.positionFlag[p.getRow()][p.getColumn()];
    }
}
