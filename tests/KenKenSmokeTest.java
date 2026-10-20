import kenken.Board;
import kenken.Cell;
import kenken.PuzzleParser;

import java.nio.file.Path;

/** A dependency-free test starter. Run after compiling the source files. */
public final class KenKenSmokeTest {
    public static void main(String[] args) throws Exception {
        testBoard();
        testParser();
        System.out.println("Smoke tests passed.");
    }

    private static void testBoard() {
        Board board = new Board(2); 
        Cell cell = new Cell(0, 1); 
        board.set(cell, 2);
        assert board.get(cell) == 2;
        assert !board.isComplete();
    }

    private static void testParser() throws Exception {
        PuzzleParser.PuzzleData puzzle = PuzzleParser.parse(Path.of("puzzle_files/3x3_1.txt"));//new code add to notes, path.
        assert puzzle.size() == 3;
        assert puzzle.cages().size() == 5;
    }
}
