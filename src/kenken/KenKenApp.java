package kenken;

import java.nio.file.Path;

public final class KenKenApp {
    private KenKenApp() { }

    public static void main(String[] args) {
        Path puzzlePath = Path.of(args.length == 0 ? "puzzle_files/3x3_1.txt" : args[0]);
        try {
            PuzzleParser.PuzzleData puzzle = PuzzleParser.parse(puzzlePath);
            KenKenSolver solver = new KenKenSolver(puzzle);
            long start = System.nanoTime();
            boolean solved = solver.solve();
            long elapsedMs = (System.nanoTime() - start) / 1_000_000;
            System.out.println("KenKen Quest — " + puzzlePath);
            System.out.println("Solved: " + solved);
            solver.board().print();
            System.out.printf("Recursive calls: %d | Candidate checks: %d | Backtracks: %d | Time: %d ms%n",
                    solver.recursiveCalls(), solver.candidateChecks(), solver.backtracks(), elapsedMs);
        } catch (Exception exception) {
            System.err.println("Could not load puzzle: " + exception.getMessage());
        }
    }
}
