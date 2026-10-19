package kenken;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/** Student starter: implement the methods marked TODO. */
public final class KenKenSolver {
    private final Board board;
    private final List<Cage> cages;
    private final Set<Integer>[] usedInRows;
    private final Set<Integer>[] usedInColumns;
    private final Queue<Cell> recentDecisions = new ArrayDeque<>();
    private long recursiveCalls;
    private long candidateChecks;
    private long backtracks;

    @SuppressWarnings("unchecked")
    public KenKenSolver(PuzzleParser.PuzzleData puzzle) {
        board = new Board(puzzle.size());
        cages = puzzle.cages();
        usedInRows = new Set[puzzle.size()];
        usedInColumns = new Set[puzzle.size()];
        for (int i = 0; i < puzzle.size(); i++) { usedInRows[i] = new HashSet<>(); usedInColumns[i] = new HashSet<>(); }
    }

    public boolean solve() {
        // TODO: increment recursiveCalls, choose an empty cell, and call search.
        // TODO: decide how the solver should behave if solve() is called twice.
        return search();
    }

    private boolean search() {
        // TODO: find an empty cell; return true when there are no empty cells.
        // TODO: try values 1..board.size(), placing and undoing each candidate.
        // TODO: update recentDecisions, row sets, and column sets during recursion.
        // TODO: increment backtracks whenever a branch fails.
        return board.isComplete();
    }

    private boolean canPlace(Cell cell, int value) {
        // TODO: use the row/column sets and the cage containing cell.
        // TODO: check that the cage can still reach its target with this value.
        candidateChecks++;
        return false;
    }

    private Cage cageContaining(Cell cell) {
        for (Cage cage : cages) if (cage.cells().contains(cell)) return cage;
        throw new IllegalStateException("No cage contains " + cell);
    }

    public Board board() { return board; }
    public long recursiveCalls() { return recursiveCalls; }
    public long candidateChecks() { return candidateChecks; }
    public long backtracks() { return backtracks; }
    public Queue<Cell> recentDecisions() { return new ArrayDeque<>(recentDecisions); }
}
