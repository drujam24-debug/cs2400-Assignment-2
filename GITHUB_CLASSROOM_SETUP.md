# GitHub Classroom Setup

## Instructor setup

1. Create or select the course GitHub organization.
2. Create a GitHub Classroom classroom for the course.
3. Create an individual assignment and connect it to a template repository containing this starter project.
4. Set the assignment title to `Assignment 2 — KenKen Quest` and the due date to **November 8, 2026**.
5. Share the generated invitation link with students.

The template repository should contain the project folder contents directly at its root, including `src/`, `tests/`, `puzzle_files/`, `README.md`, and the GitHub Actions workflow.

## Student setup

1. Open the invitation link while signed in to GitHub.
2. Accept the assignment. GitHub Classroom creates your private assigned repository.
3. Copy the repository URL from the new repository page.
4. Clone it locally:

   ```bash
   git clone https://github.com/YOUR-ORGANIZATION/YOUR-ASSIGNED-REPOSITORY.git
   cd YOUR-ASSIGNED-REPOSITORY
   ```

5. Open the cloned folder in IntelliJ IDEA or Visual Studio Code.
6. Work only in your assigned repository, then save, commit, and push:

   ```bash
   git add .
   git commit -m "Complete KenKen Assignment 2"
   git push origin main
   ```

7. Check the repository’s **Actions** tab for the compile-and-smoke-test result.
8. Submit the repository link using the course’s submission instructions.

If your repository uses `master` instead of `main`, replace `main` in the commands with `master`.
