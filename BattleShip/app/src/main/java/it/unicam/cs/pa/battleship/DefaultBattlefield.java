package it.unicam.cs.pa.battleship;

/**
 * Default representation of the battlefield.
 */
public class DefaultBattlefield implements Battlefield{

    private static final int DEFAULT_SIZE = 10;
    private static final int DEFAULT_WIDTH = DEFAULT_SIZE;
    private static final int DEFAULT_HEIGHT = DEFAULT_SIZE;
    private final Ship[][] field;
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
     * @param width the width of the battlefield
     * @param height the height of the battlefield
     */
    public DefaultBattlefield(int width, int height) {
        this.field = new Ship[width][height];
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean addship(Ship ship, int row, int column, Direction dir) {
        return false;
    }

    @Override
    public ShotResult shootAt(int row, int column) {
        return null;
    }

    @Override
    public Ship shipAt(int row, int column) {
        return null;
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
    public ShotResult status(int row, int column) {
        return null;
    }
}
