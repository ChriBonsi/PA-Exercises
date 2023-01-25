package it.unicam.cs.pa.battleship;

import com.google.common.base.Objects;

/**
 * Identifies a position into the battlefield.
 */
public class FieldPosition {
    private final int row;
    private final int column;

    /**
     * Constructs an object FieldPosition with the specified coordinates.
     *
     * @param row    the row of the location
     * @param column the column of the location
     */
    public FieldPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Returns the row of the location.
     *
     * @return the row of the location.
     */
    public int getRow() {
        return row;
    }

    /**
     * Returns the column of the location.
     *
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
        return getRow() == that.getRow() && getColumn() == that.getColumn();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getRow(), getColumn());
    }

    @Override
    public String toString() {
        return "FieldPosition{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }
}
