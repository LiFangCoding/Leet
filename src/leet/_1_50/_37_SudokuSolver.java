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
        // each row can have 9 digits. used or not
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] subBoxs = new boolean[9][10];

        public void solveSudoku(char[][] board) {
            if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
                return;
            }

            // mark the value for each box
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == '.') {
                        continue;
                    }

                    int val = board[i][j] - '0';
                    rows[i][val] = true;
                    cols[j][val] = true;
                    subBoxs[i / 3 * 3 + j / 3][val] = true;
                }
            }

            search(board, 0, 0);
        }

        private boolean search(char[][] board, int x, int y) {
            if (x == board.length) {
                return true;
            }

            if (y == board[0].length) {
                return search(board, x + 1, 0);
            }

            if (board[x][y] != '.') {
                return search(board, x, y + 1);
            }

            // how about the x, y is the not '.'
            for (int k = 1; k <= 9; k++) {
                if (!rows[x][k] && !cols[y][k] && !subBoxs[x / 3 * 3 + y / 3][k]) {
                    rows[x][k] = cols[y][k] = subBoxs[x / 3 * 3 + y / 3][k] = true;

                    board[x][y] = (char) (k + '0');
                    if (search(board, x, y + 1)) {
                        return true;
                    }

                    // if true, no need to return back
                    board[x][y] = '.';
                    rows[x][k] = cols[y][k] = subBoxs[x / 3 * 3 + y / 3][k] = false;
                }
            }

            // where is return false. else always return true
            return false;
        }
    }
}
