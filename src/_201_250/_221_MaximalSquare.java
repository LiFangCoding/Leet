package _201_250;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * Output: 4
 */
public class _221_MaximalSquare {
  public int maximalSquare(char[][] matrix) {
    // f[i][j] means the len of max square for right point i,j
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

    int n = matrix.length, m = matrix[0].length;
    int[][] f = new int[n + 1][m + 1];

    int res = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        // ith row and jth col is the matrix[i - 1][j - 1]
        if (matrix[i - 1][j - 1] == '1') {
          f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i][j - 1], f[i - 1][j])) + 1;
          res = Math.max(res, f[i][j]);
        }
      }
    }

    return res * res;
  }
}
