package leet._651_700;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * <p>
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 * <p>
 * Example 1:
 * <p>
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 * <p>
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 * Note: The length of each dimension in the given grid does not exceed 50.
 */
public class _695_Max_Area_of_Island {
    class Solution_more_clean {
        int land = 1;
        int water = 0;
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        public int maxAreaOfIsland(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
                return 0;
            }

            int ans = 0;

            for (int x = 0; x < grid.length; x++) {
                for (int y = 0; y < grid[0].length; y++) {
                    if (grid[x][y] == land) {
                        ans = Math.max(ans, dfs(grid, x, y));
                    }
                }
            }

            return ans;
        }

        private int dfs(int[][] grid, int x, int y) {
            grid[x][y] = water;
            int area = 1;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == land) {
                    area += dfs(grid, nx, ny);
                }
            }

            return area;
        }
    }

    int count = 0;
    int m;
    int n;
    int land = 1;
    int water = 0;
    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int ans = 0;
        m = grid.length;
        n = grid[0].length;

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (grid[x][y] == land) {
                    dfs(grid, x, y);
                    ans = Math.max(ans, count);
                    count = 0;
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == water) {
            return;
        }

        grid[x][y] = water;
        count++;

        for (int i = 0; i < dx.length; i++) {
            dfs(grid, x + dx[i], y + dy[i]);
        }
    }
}
