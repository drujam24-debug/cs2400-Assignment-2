package kenken;

import java.util.Arrays;

/** Mutable square grid. A zero means that the cell is not filled yet. */
public final class Board {
    private final int[][] values;

    public Board(int size) {
        if (size < 1) throw new IllegalArgumentException("Board size must be positive.");
        values = new int[size][size];
    }

    public int size() { return values.length; }
    public int get(Cell cell) { return values[cell.row()][cell.column()]; }
    public void set(Cell cell, int value) {
        // TODO: reject values outside 0..size(); zero means "empty".
        values[cell.row()][cell.column()] = value;
    }
    public boolean isComplete() {
        for (int[] row : values) for (int value : row) if (value == 0) return false;
        return true;
    }
    public int[][] copyValues() {
        int[][] copy = new int[size()][size()];
        for (int row = 0; row < size(); row++) copy[row] = Arrays.copyOf(values[row], size());
        return copy;
    }
    public void print() {
        for (int[] row : values) System.out.println(Arrays.toString(row));
    }
}
