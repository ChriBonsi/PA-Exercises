package it.unicam.cs.pa.battleship;

public enum Direction {
    NORTH(0, 1), SOUTH(0, -1), EAST(1, 0), WEST(-1, 0);

    private final int dx;
    private final int dy;

    Direction(int x, int y) {
        this.dx = x;
        this.dy = y;
    }


    public FieldPosition[] computePositions(int row, int column, int size) {
        FieldPosition[] result = new FieldPosition[size];

        for (int i = 0; i < size; i++) {
            result[i] = new FieldPosition(row + i * dx, column + i * dy);
        }
        return result;
    }

}
