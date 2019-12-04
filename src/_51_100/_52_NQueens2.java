package _51_100;

import java.util.ArrayList;
import java.util.List;

public class _52_NQueens2 {
  public int totalNQueens(int n) {
    if (n <= 0) {
      return 0;
    }

    int[] A = new int[]{0};
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

  public static void main(String[] args) {
    _52_NQueens2 test = new _52_NQueens2();
    System.out.println(test.totalNQueens(4));
  }
}
