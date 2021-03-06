package leet._1_50;

/**
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * <p>
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * <p>
 * A partially filled sudoku which is valid.
 * <p>
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * ['5','3','.','.','7','.','.','.','.'],
 * ['6','.','.','1','9','5','.','.','.'],
 * ['.','9','8','.','.','.','.','6','.'],
 * ['8','.','.','.','6','.','.','.','3'],
 * ['4','.','.','8','.','3','.','.','1'],
 * ['7','.','.','.','2','.','.','.','6'],
 * ['.','6','.','.','.','.','2','8','.'],
 * ['.','.','.','4','1','9','.','.','5'],
 * ['.','.','.','.','8','.','.','7','9']
 * ]
 * Output: true
 * Example 2:
 * <p>
 * Input:
 * [
 * ['8','3','.','.','7','.','.','.','.'],
 * ['6','.','.','1','9','5','.','.','.'],
 * ['.','9','8','.','.','.','.','6','.'],
 * ['8','.','.','.','6','.','.','.','3'],
 * ['4','.','.','8','.','3','.','.','1'],
 * ['7','.','.','.','2','.','.','.','6'],
 * ['.','6','.','.','.','.','2','8','.'],
 * ['.','.','.','4','1','9','.','.','5'],
 * ['.','.','.','.','8','.','.','7','9']
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 * modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * Note:
 * <p>
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 */
public class _36_ValidSudoku {
    /**
     * T = O(sizeofBoard)
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return false;
        }

        // check each row, col, subbox, check does it have 1-9 in each one. One easy way is integer check
        int m = board.length, n = board[0].length;
        boolean[][] rows = new boolean[9][10], cols = new boolean[9][10];
        boolean[][][] cell = new boolean[3][3][10];

        // i means row. j is col
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                // pay attention. Here val is from 1 - 9.
                int t = board[i][j] - '0';
                if (rows[i][t] || cols[j][t] || cell[i / 3][j / 3][t]) {
                    return false;
                }

                rows[i][t] = cols[j][t] = cell[i / 3][j / 3][t] = true;
            }
        }

        return true;
    }
}
