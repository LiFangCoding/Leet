import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an N x N grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized and return the distance.
 * <p>
 * The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 * <p>
 * If no land or water exists in the grid, return -1.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: [[1,0,1],[0,0,0],[1,0,1]]
 * Output: 2
 * Explanation:
 * The cell (1, 1) is as far as possible from all the land with distance 2.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: [[1,0,0],[0,0,0],[0,0,0]]
 * Output: 4
 * Explanation:
 * The cell (2, 2) is as far as possible from all the land with distance 4.
 *  
 * <p>
 * Note:
 * <p>
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] is 0 or 1
 */
public class _1162_As_Far_from_Land_as_Possible {
    int water = 0;
    int land = 1;

    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // it is for the x and y
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == land) {
                    q.add(new int[]{i, j});
                }
            }
        }

        if (q.isEmpty() || q.size() == m * n) {
            return -1;
        }

        /**
         * Important: because level++ is after. So it should be the level == -1
         */
        int level = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.remove();
                for (int k = 0; k < 4; k++) {
                    int newx = cur[0] + dx[k];
                    int newy = cur[1] + dy[k];

                    if (newx < 0 || newx >= m || newy < 0 || newy >= n) {
                        continue;
                    }

                    if (grid[newx][newy] == water) {
                        grid[newx][newy] = land;
                        q.add(new int[]{newx, newy});
                    }
                }
            }
            level++;
        }

        return level;
    }
}
