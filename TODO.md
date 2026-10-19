# Starter TODOs

Work in this order. Keep each change small enough to compile and test.

- [ ] Run `KenKenSmokeTest` and confirm that the parser reads `3x3_1.txt`.
- [ ] Finish `Board.set` validation and add tests for invalid coordinates/values.
- [ ] Add stronger duplicate-cell validation to `Cage` or `PuzzleParser`.
- [ ] Write a helper that finds the cage containing a `Cell`.
- [ ] Implement cage arithmetic for `+`, `-`, `*`, `/`, and single-cell cages.
- [ ] Implement `KenKenSolver.canPlace` using row and column `HashSet`s.
- [ ] Implement recursive search in `KenKenSolver`.
- [ ] Undo every board, set, and queue change when a branch fails.
- [ ] Add tests for a solved puzzle, an unsolvable puzzle, malformed input, and a larger puzzle.
- [ ] Compare row-major search with a fewest-candidates heuristic.
- [ ] Complete `REPORT.md` with design decisions and complexity analysis.

The starter intentionally leaves the solver incomplete. A successful compile is expected;
`Solved: false` is normal until the solver TODOs are implemented.
