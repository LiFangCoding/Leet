import java.util.HashMap;
import java.util.Map;

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
  // Map<String, Integer> map;
  int[][] cache;
  int m;
  int n;
  int[] dx = {-1, 1, 0, 0};
  int[] dy = {0, 0, -1 ,1};

  public int longestIncreasingPath(int[][] M) {
    if (M == null || M.length == 0 || M[0] == null || M[0].length == 0) {
      return 0;
    }

    // map = new HashMap<>();

    int ans = 0;
    m = M.length;
    n = M[0].length;
    cache = new int[m][n];

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

    if (cache[x][y] != 0) {
      return cache[x][y];
    }
    int ans = 0;
    for (int i = 0; i < 4; i++) {
      int newx = x + dx[i];
      int newy = y + dy[i];

      if  (newx >=0 && newx <= m -1 && newy >= 0 && newy <= n - 1 && M[newx][newy] > M[x][y]) {
        ans = Math.max(ans, dfs(M, newx, newy));
      }
    }
    ans++;

    cache[x][y] = ans;
    return ans;
  }

  public static void main(String[] args) {
    _329_Longest_Increasing_Path_in_a_Matrix test = new _329_Longest_Increasing_Path_in_a_Matrix();
    int[][] M = {
        {9, 9, 4},
        {6,6,8},
        {2,1,1}
    };

    System.out.println(test.longestIncreasingPath(M));
  }
}
