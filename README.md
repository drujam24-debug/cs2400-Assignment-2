# CS 2400 — KenKen Assignment 2 Starter

This is a clean Java 17 starting point based on the original KenKen project. The puzzle data and reference images are preserved, while the old Eclipse metadata, compiled `.class` files, and `bin` folder are intentionally omitted.

The starter is designed for IntelliJ IDEA or Visual Studio Code. It gives you the model classes, parser, command-line entry point, smoke test, and a solver skeleton with TODOs. The recursive solver is intentionally incomplete so that the main algorithm remains your work.

## Folder map

```text
src/kenken/        Java source files
tests/             dependency-free starter test
puzzle_files/      original KenKen puzzle inputs
images/            original puzzle and solution reference images
.github/workflows/ GitHub Actions compile-and-test check
TODO.md            recommended implementation order
```

## Start in IntelliJ IDEA

1. Open the `KenKen_Assignment2_Starter` folder.
2. Select a Java 17 (or newer) SDK under **File → Project Structure → Project**.
3. Right-click `src` and choose **Mark Directory as → Sources Root** if IntelliJ does not detect it.
4. Run `kenken.KenKenApp`.

## Start in Visual Studio Code

1. Open the `KenKen_Assignment2_Starter` folder.
2. Install the **Extension Pack for Java** if prompted.
3. Confirm that VS Code is using Java 17 or newer.
4. Open `src/kenken/KenKenApp.java` and select **Run Java**.

## Compile from a terminal

```bash
mkdir -p out
javac -d out src/kenken/*.java tests/KenKenSmokeTest.java
java -ea -cp out KenKenSmokeTest
java -cp out kenken.KenKenApp puzzle_files/3x3_1.txt
```

The starter smoke test should pass. Until the solver TODOs are complete, the application may print `Solved: false`; that is expected.

## GitHub workflow

```bash
git clone (https://github.com/fzj0007/cs2400-Assignment-2.git)
cd YOUR-ASSIGNED-REPOSITORY
```

Copy or unzip this starter into that repository, then commit and push your work:

```bash
git add .
git commit -m "Start KenKen Assignment 2"
git push origin main
```

Continue to push after each milestone. GitHub Actions will compile the source and run the smoke test after each push. Submit the repository URL through the course submission instructions when you are finished.

## Assignment details

Read `Assignment2_kenken.pdf` for the project requirements, due date, expected tests, and grading rubric. 

Read `TODO.md` for the recommended implementation sequence.
