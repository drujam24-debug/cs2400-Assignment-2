package kenken;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** One connected arithmetic region of a KenKen puzzle. */
public final class Cage {
    private final int target;
    private final char operator;
    private final List<Cell> cells = new ArrayList<>();

    public Cage(int target, char operator) {
        if (target < 1) throw new IllegalArgumentException("A cage target must be positive.");
        if (operator != ' ' && operator != '+' && operator != '-' && operator != '*' && operator != '/') {
            throw new IllegalArgumentException("Unsupported cage operator: " + operator);
        }
        this.target = target;
        this.operator = operator;
    }

    public void addCell(Cell cell) {
        // TODO: reject duplicate cells when you strengthen the model validation.
        cells.add(cell);
    }
    public int target() { return target; }
    public char operator() { return operator; }
    public List<Cell> cells() { return Collections.unmodifiableList(cells); }
    public boolean isSingleCell() { return cells.size() == 1; }

    @Override public String toString() {
        return target + " " + operator + " " + cells;
    }
}
