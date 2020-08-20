package _301_350;

/**
 * Given an integer matrix, find the length of the longest increasing path.
 *
 * From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 *
 * Example 1:
 *
 * Input: nums =
 * [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 * Example 2:
 *
 * Input: nums =
 * [
 *   [3,4,5],
 *   [3,2,6],
 *   [2,2,1]
 * ]
 * Output: 4
 * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */
public class _329_Longest_Increasing_Path_in_a_Matrix {

  /**
   * 由于这道题目的状态依赖关系比较复杂，不容易用循环来求每个状态的值，所以可以用记忆化搜索来做：如果某个状态还没计算过，则递归计算该状态的值。
   */
  class Sol_memo {
    // Map<String, Integer> map;
    int[][] f;
    int m;
    int n;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int longestIncreasingPath(int[][] M) {
      if (M == null || M.length == 0 || M[0] == null || M[0].length == 0) {
        return 0;
      }

      // map = new HashMap<>();

      int ans = 0;
      m = M.length;
      n = M[0].length;
      f = new int[m][n];

      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          ans = Math.max(ans, dfs(M, i, j));
        }
      }

      return ans;
    }

    private int dfs(int[][] M, int x, int y) {
      // String s = x + "," + y;
      // if (map.containsKey(s)) {
      //     return map.get(s);
      // }

      if (f[x][y] != 0) {
        return f[x][y];
      }

      int ans = 0;
      for (int i = 0; i < 4; i++) {
        int newx = x + dx[i];
        int newy = y + dy[i];

        if (newx >= 0 && newx <= m - 1 && newy >= 0 && newy <= n - 1 && M[newx][newy] > M[x][y]) {
          ans = Math.max(ans, dfs(M, newx, newy));
        }
      }
      ans++;

      f[x][y] = ans;
      return ans;
    }
  }
}
