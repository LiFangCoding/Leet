import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * In a 2D grid of 0s and 1s, we change at most one 0 to a 1.
 * <p>
 * After, what is the size of the largest island? (An island is a 4-directionally connected group of 1s).
 * <p>
 * Example 1:
 * <p>
 * Input: [[1, 0], [0, 1]]
 * Output: 3
 * Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
 * Example 2:
 * <p>
 * Input: [[1, 1], [1, 0]]
 * Output: 4
 * Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
 * Example 3:
 * <p>
 * Input: [[1, 1], [1, 1]]
 * Output: 4
 * Explanation: Can't change any 0 to 1, only one island with area = 4.
 *  
 * <p>
 * Notes:
 * <p>
 * 1 <= grid.length = grid[0].length <= 50.
 * 0 <= grid[i][j] <= 1.
 */
public class _827_Making_A_large_land {
    int m;
    int n;
    int color;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int largestIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        color = 2;
        // color -> count
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int count = dfs(grid, i, j);
                    ans = Math.max(ans, count);
                    map.put(color, count);
                    color++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curAns = 1;
                Set<Integer> colorSet = new HashSet<>();
                if (grid[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int newx = i + dx[k];
                        int newy = j + dy[k];

                        if (newx < 0 || newx >= m || newy < 0 || newy >= n || grid[newx][newy] == 0) {
                            continue;
                        }

                        colorSet.add(grid[newx][newy]);
                    }
                }

                for (int color : colorSet) {
                    curAns += map.get(color);
                }


                ans = Math.max(curAns, ans);
            }
        }

        return ans;
    }

    private int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1) {
            return 0;
        }

        grid[x][y] = color;

        int ans = 1;
        for (int k = 0; k < 4; k++) {
            ans += dfs(grid, x + dx[k], y + dy[k]);
        }

        return ans;
    }
}
