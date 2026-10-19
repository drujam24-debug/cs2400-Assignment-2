package kenken;

/** A coordinate in the puzzle grid. Rows and columns are zero-based. */
public record Cell(int row, int column) {
    public Cell {
        if (row < 0 || column < 0) {
            throw new IllegalArgumentException("Cell coordinates cannot be negative.");
        }
    }
}
