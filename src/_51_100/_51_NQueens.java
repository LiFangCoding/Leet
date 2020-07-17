package _51_100;

import java.util.ArrayList;
import java.util.List;

public class _51_NQueens {
  //TODO
  /**
   * 3ms
   */
  class Sol_Clean {
    boolean[] cols;
    boolean[] dia;
    boolean[] rev;
    List<List<String>> ans;

    public List<List<String>> solveNQueens(int n) {
      cols = new boolean[n];
      // x + y. range is from 0 - 2n -2.
      dia = new boolean[2 * n];
      // x - y +  n - 1
      rev = new boolean[2 * n];

      ans = new ArrayList<>();
      solve(n, 0, new ArrayList<>());

      return ans;
    }

    private void solve(int n, int row, List<String> path) {
      if (row == n) {
        ans.add(new ArrayList<>(path));
        return;
      }

      for (int col = 0; col < n; col++) {
        if (!cols[col] && !dia[row + col] && !rev[row - col + n - 1]) {
          cols[col] = dia[row + col] = rev[row - col + n - 1] = true;
          StringBuilder sb = new StringBuilder();
          for (int k = 0; k < n; k++) {
            if (k != col) {
              sb.append('.');
            } else {
              sb.append('Q');
            }
          }
          path.add(sb.toString());
          solve(n, row + 1, path);
          path.remove(path.size() - 1);
          cols[col] = dia[row + col] = rev[row - col + n - 1] = false;
        }
      }
    }
  }

  /**
   * 3ms
   */
  class Solution_shorter {
    List<List<String>> ans;

    public List<List<String>> solveNQueens(int n) {
      ans = new ArrayList<>();
      if (n == 0) {
        return ans;
      }

      List<String> board = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
          sb.append('.');
        }
        board.add(sb.toString());
      }

      boolean[] column = new boolean[n];
      boolean[] ldiag = new boolean[2 * n - 1];
      boolean[] rdiag = new boolean[2 * n - 1];

      dfs(board, column, ldiag, rdiag, 0, n);
      return ans;
    }

    private void dfs(List<String> board, boolean[] column, boolean[] ldiag, boolean[] rdiag, int row, int n) {
      if (row == n) {
        ans.add(new ArrayList<>(board));
        return;
      }

      // iterate all the cols. i means column
      for (int i = 0; i < n; i++) {
        if (column[i] || ldiag[i + row] || rdiag[i - row + n - 1]) {
          continue;
        }

        String s = board.get(row);
        char[] chars = s.toCharArray();
        chars[i] = 'Q';
        board.set(row, new String(chars));
        column[i] = ldiag[i + row] = rdiag[i - row + n - 1] = true;
        dfs(board, column, ldiag, rdiag, row + 1, n);
        column[i] = ldiag[i + row] = rdiag[i - row + n - 1] = false;
        chars[i] = '.';
        board.set(row, new String(chars));
      }
    }
  }

  public List<List<String>> solveNQueens(int n) {
    List<List<String>> res = new ArrayList<>();

    if (n <= 0) {
      return res;
    }

    helper(n, new ArrayList<>(), res);
    return res;
  }

  private void helper(int n, List<Integer> chosen, List<List<String>> res) {
    if (chosen.size() == n) {
      res.add(draw(chosen));
    }

    for (int i = 0; i < n; i++) {
      if (isValid(chosen, i)) {
        chosen.add(i);
        helper(n, chosen, res);
        chosen.remove(chosen.size() - 1);
      }
    }
  }

  private boolean isValid(List<Integer> chosen, int icol) {
    // row conflict. The row is chosen.size(), not chosen.size() + 1.
    int irow = chosen.size();

    // col conflict
    for (int row = 0; row < chosen.size(); row++) {
      int col = chosen.get(row);
      if (icol == col) {
        return false;
      }

      if (Math.abs(irow - row) == Math.abs(icol - col)) {
        return false;
      }
    }

    return true;
  }

  // for each row, try the position, if ok, continue, else go down
  private List<String> draw(List<Integer> chosen) {
    List<String> res = new ArrayList<>();
    int n = chosen.size();

    for (int i : chosen) {
      StringBuilder sb = new StringBuilder();

      for (int j = 0; j < n; j++) {
        sb.append(j == i ? 'Q' : '.');
      }

      res.add(sb.toString());
    }

    return res;
  }

  public static void main(String[] args) {
    _51_NQueens test = new _51_NQueens();

    System.out.println(test.solveNQueens(4));
  }
}
