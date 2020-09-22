package leet._1_50;

/**
 *
 */
public class _37_SudokuSolver {
    //TODO
    /**
     * 2ms
     * backtracking
     */
    class Sol_fast {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][][] cell = new boolean[3][3][10];

        public void solveSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        int t = board[i][j] - '0';
                        row[i][t] = col[j][t] = cell[i / 3][j / 3][t] = true;
                    }
                }
            }

            dfs(board, 0, 0);
        }

        boolean dfs(char[][] board, int x, int y) {
            if (y == 9) {
                return dfs(board, x + 1, 0);
            }

            if (x == 9) return true;
            if (board[x][y] != '.') return dfs(board, x, y + 1);
            for (int i = 1; i <= 9; i++) {
                if (!row[x][i] && !col[y][i] && !cell[x / 3][y / 3][i]) {
                    board[x][y] = (char) ('0' + i);
                    row[x][i] = col[y][i] = cell[x / 3][y / 3][i] = true;

                    if (dfs(board, x, y + 1)) return true;

                    board[x][y] = '.';
                    row[x][i] = col[y][i] = cell[x / 3][y / 3][i] = false;
                }
            }
            return false;
        }
    }
}
