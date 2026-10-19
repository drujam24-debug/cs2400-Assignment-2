package kenken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/** Reads the supplied puzzle format and performs structural validation. */
public final class PuzzleParser {
    private PuzzleParser() { }

    public static PuzzleData parse(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path).stream()
                .map(String::trim).filter(line -> !line.isEmpty()).toList();
        if (lines.size() < 2) throw new IllegalArgumentException("Puzzle needs a size and cage count.");
        int index = 0;
        int size = positiveInt(lines.get(index++), "size");
        int cageCount = positiveInt(lines.get(index++), "cage count");
        List<Cage> cages = new ArrayList<>();
        boolean[][] claimed = new boolean[size][size];
        for (int cageNumber = 0; cageNumber < cageCount; cageNumber++) {
            if (index >= lines.size()) throw new IllegalArgumentException("Missing data for cage " + cageNumber + ".");
            String[] header = lines.get(index++).split(",", -1);
            if (header.length != 3) throw new IllegalArgumentException("Bad cage header: " + lines.get(index - 1));
            int target = positiveInt(header[0], "cage target");
            String operatorText = header[1].trim();
            char operator = operatorText.isEmpty() ? ' ' : operatorText.charAt(0);
            int cellCount = positiveInt(header[2], "cell count");
            Cage cage = new Cage(target, operator);
            for (int cellNumber = 0; cellNumber < cellCount; cellNumber++) {
                if (index >= lines.size()) throw new IllegalArgumentException("Missing cell in cage " + cageNumber + ".");
                String[] coordinate = lines.get(index++).split(",", -1);
                if (coordinate.length != 2) throw new IllegalArgumentException("Bad coordinate: " + lines.get(index - 1));
                int row = positiveOrZero(coordinate[0], "row");
                int column = positiveOrZero(coordinate[1], "column");
                if (row >= size || column >= size) throw new IllegalArgumentException("Coordinate outside board: " + row + "," + column);
                if (claimed[row][column]) throw new IllegalArgumentException("Cell appears in more than one cage: " + row + "," + column);
                claimed[row][column] = true;
                cage.addCell(new Cell(row, column));
            }
            cages.add(cage);
        }
        for (int row = 0; row < size; row++) for (int column = 0; column < size; column++)
            if (!claimed[row][column]) throw new IllegalArgumentException("Cell is not assigned to a cage: " + row + "," + column);
        // TODO: reject unexpected nonblank lines after the final cage.
        return new PuzzleData(size, cages);
    }

    private static int positiveInt(String text, String label) { int value = positiveOrZero(text, label); if (value < 1) throw new IllegalArgumentException(label + " must be positive."); return value; }
    private static int positiveOrZero(String text, String label) { try { int value = Integer.parseInt(text); if (value < 0) throw new IllegalArgumentException(label + " cannot be negative."); return value; } catch (NumberFormatException e) { throw new IllegalArgumentException("Invalid " + label + ": " + text); } }

    public record PuzzleData(int size, List<Cage> cages) { }
}
