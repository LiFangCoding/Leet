package leet._51_100;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class _64_Minimum_Path_Sum {
    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] f = new int[rows][cols];

        f[0][0] = grid[0][0];

        for (int i = 1; i < rows; i++) {
            f[i][0] = f[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < cols; j++) {
            f[0][j] = f[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
            }
        }

        return f[rows - 1][cols - 1];
    }
}
