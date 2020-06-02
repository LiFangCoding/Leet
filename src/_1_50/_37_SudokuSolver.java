package _1_50;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class _37_SudokuSolver {
  /**
   * 2ms
   * backtracking
   */
  class Sol_fast {
    // each row can have 9 digits. used or not
    boolean[][] rows = new boolean[9][10];
    boolean[][] cols = new boolean[9][10];
    boolean[][][] subBoxs = new boolean[3][3][10];

    public void solveSudoku(char[][] board) {
      if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
        return;
      }

      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
          if (board[i][j] == '.') {
            continue;
          }

          int val = board[i][j] - '0';
          rows[i][val] = true;
          cols[j][val] = true;
          subBoxs[i / 3][j / 3][val] = true;
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

      // how about the x, y is the not '.'
      if (board[x][y] == '.') {
        for (int k = 1; k <= 9; k++) {
          if (!rows[x][k] && !cols[y][k] && !subBoxs[x / 3][y / 3][k]) {
            rows[x][k] = cols[y][k] = subBoxs[x / 3][y / 3][k] = true;
            board[x][y] = (char) (k + '0');
            if (search(board, x, y + 1)) {
              return true;
            }
            // if true, no need to return back
            board[x][y] = '.';
            rows[x][k] = cols[y][k] = subBoxs[x / 3][y / 3][k] = false;
          }
        }
      } else {
        return search(board, x, y + 1);
      }

      // where is return false. else always return true
      return false;
    }
  }

  /**
   * 1017 ms
   * backtracking
   * does not use the boolean array to check quickly
   */
  class Sol_Slow {
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
}
