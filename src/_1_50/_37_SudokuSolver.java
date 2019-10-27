package _1_50;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class _37_SudokuSolver {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        _37_SudokuSolver test = new _37_SudokuSolver();

        test.solveSudoku(board);

        System.out.println(Arrays.deepToString(board));
    }

    public void solveSudoku(char[][] board) {
        sudokuHelper(board);
    }

    private boolean sudokuHelper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int val = 1; val <= 9; val++) {
                        board[i][j] = (char) ('0' + val);
                        if (isValidSudoku(board) && sudokuHelper(board)) {
                            /**
                             * backtrack here
                             */
                            System.out.println("Current board for " + i + " " + j + "is ");
                            return true;
                        }
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }

        // base case. When it is true.
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return false;
        }

        // rule row
        for (int i = 0; i < 9; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                int val = board[i][j] - '0';
                if (set.contains(val)) {
                    return false;
                }

                set.add(val);
            }
        }

        // rule col
        for (int j = 0; j < 9; j++) {
            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.') {
                    continue;
                }

                int val = board[i][j] - '0';

                if (set.contains(val)) {
                    return false;
                }

                set.add(val);
            }
        }

        // rule subbox
        for (int i = 0; i < 9; i++) {
            Set<Integer> set = new HashSet<>();
            /**
             * 0 -> 0,2 0,2
             * 1 -> 3,5 0,2
             * 2 -> 6,8 0,2
             * 3 -> 3,5 3,5
             */

            for (int j = 0; j < 9; j++) {
                int row = (i / 3) * 3 + j / 3;
                int col = (i % 3) * 3 + j % 3;

                if (board[row][col] == '.') {
                    continue;
                }

                int val = board[row][col] - '0';

                if (set.contains(val)) {
                    return false;
                }

                set.add(val);
            }
        }

        return true;
    }
}
