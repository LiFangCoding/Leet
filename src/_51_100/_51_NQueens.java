package _51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * <p>
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * <p>
 * Example:
 * <p>
 * Input: 4
 * Output: [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

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

    class Sol_seperate {
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
    }
}
