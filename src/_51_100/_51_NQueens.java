package _51_100;

import java.util.ArrayList;
import java.util.List;

public class _51_NQueens {
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
