package leet._51_100;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 */
public class _63_Unique_Paths2 {
    /**
     * 1 ms
     * T = m * n
     */
    int obs = 1;

    public int uniquePathsWithObstacles(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length, cols = grid[0].length;
        // f[i][j] means how many ways to arrive i and j
        // f[i][j] = f[i - 1][j] + f[i][j - 1] if not obs. if obs, 0
        int[][] f = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == obs) {
                    f[i][j] = 0;
                    continue;
                }

                if (i == 0 && j == 0) {
                    f[i][j] = 1;
                } else {
                    if (i > 0) {
                        f[i][j] += f[i - 1][j];
                    }

                    if (j > 0) {
                        f[i][j] += f[i][j - 1];
                    }
                }
            }
        }

        return f[rows - 1][cols - 1];
    }
}
