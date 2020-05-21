package _501_550;

/**
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1.
 *
 *  
 *
 * Example 1:
 *
 * Input:
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 *
 * Output:
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 * Example 2:
 *
 * Input:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,1,1]]
 *
 * Output:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,2,1]]
 *  
 *
 * Note:
 *
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right.
 */
public class _542_01Matrix {
  public int[][] updateMatrix(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0] == null ||
            matrix[0].length == 0) {
      return new int[0][0];
    }

    int n = matrix.length;
    int m = matrix[0].length;

    int[][] dp = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        dp[i][j] = Integer.MAX_VALUE - 1;
        if (matrix[i][j] == 0) {
          dp[i][j] = 0;
        } else {
          if (j > 0) {
            dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
          }

          if (i > 0) {
            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
          }
        }
      }
    }

    for (int i = n - 1; i >= 0; i--) {
      for (int j = m - 1; j >= 0; j--) {
        if (matrix[i][j] != 0) {
          if (j < m - 1) {
            dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
          }

          if (i < n - 1) {
            dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
          }
        }
      }
    }

    return dp;
  }
}
