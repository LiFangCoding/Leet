package _51_100;

import java.util.ArrayList;
import java.util.List;

public class _52_NQueens2 {
  /**
   * 1ms
   */
  class Sol_array_track {
    boolean[] cols;
    boolean[] dia;
    boolean[] rev;
    int ans;

    public int totalNQueens(int n) {
      cols = new boolean[n];
      // x + y. range is from 0 - 2n -2.
      dia = new boolean[2 * n];
      // x - y +  n - 1
      rev = new boolean[2 * n];

      ans = 0;
      solve(n, 0);
      return ans;
    }

    private void solve(int n, int row) {
      if (row == n) {
        ans++;
        return;
      }

      for (int col = 0; col < n; col++) {
        if (!cols[col] && !dia[row + col] && !rev[row - col + n - 1]) {
          cols[col] = dia[row + col] = rev[row - col + n - 1] = true;
          solve(n, row + 1);
          cols[col] = dia[row + col] = rev[row - col + n - 1] = false;
        }
      }
    }
  }

  /**
   * 5ms
   */
  class Sol_old {
    public int totalNQueens(int n) {
      if (n <= 0) {
        return 0;
      }

      int[] A = new int[] { 0 };
      // chosen is for all the columns on each row
      search(n, new ArrayList<Integer>(), A);
      return A[0];
    }

    private void search(int n, List<Integer> chosen, int[] A) {
      if (chosen.size() == n) {
        A[0]++;
      }

      for (int i = 0; i < n; i++) {
        if (isValid(chosen, i)) {
          chosen.add(i);
          search(n, chosen, A);
          chosen.remove(chosen.size() - 1);
        }
      }
    }

    private boolean isValid(List<Integer> chosen, int newCol) {
      int newRow = chosen.size();

      for (int row = 0; row < chosen.size(); row++) {
        int col = chosen.get(row);

        if (col == newCol) {
          return false;
        }

        if (newRow - row == Math.abs(newCol - col)) {
          return false;
        }
      }

      return true;
    }
  }
}
