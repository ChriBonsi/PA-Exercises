package it.unicam.cs.pa.battleship;

import java.util.Objects;

/**
 * Identifies a position into the battlefield.
 */
public class FieldPosition {
    private final int row;
    private final int column;

    /**
     * Constructs an object FieldPosition with the specified coordinates.
     * @param row the row of the location
     * @param column the column of the location
     */
    public FieldPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Returns the row of the location.
     * @return the row of the location.
     */
    public int getRow() {
        return row;
    }

    /**
     * Returns the column of the location.
     * @return the column of the location.
     */
    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FieldPosition that = (FieldPosition) o;

        if (getRow() != that.getRow()) return false;
        return getColumn() == that.getColumn();
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public String toString() {
        return "FieldPosition{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }
}
