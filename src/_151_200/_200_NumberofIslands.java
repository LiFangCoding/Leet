package _151_200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * Output: 1
 * Example 2:
 * <p>
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * Output: 3i
 */
public class _200_NumberofIslands {
    int m;
    int n;

    /**
     * No need visited. Because it change the grid value to be '0'. It is not '1' and cannot be seen.
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        m = grid.length;
        n = grid[0].length;

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
//                    dfs(grid, i, j);
                    bfs(grid, i, j);
                    /**
                     *
                     */
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int x, int y) {
        /**
         * !!! not valid is the x < 0 || y < 0. No = 0.
         *
         * The valid need the value to be '1'.
         *
         * Need to be careful the value should be '1', then it can continue
         */
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }

        if (grid[x][y] != '1') {
            return;
        }

        grid[x][y] = '0';

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for (int i = 0; i < dx.length; i++) {
            dfs(grid, x + dx[i], y + dy[i]);
        }
    }

    private void bfs(char[][] grid, int x, int y) {
        if (grid[x][y] != '1') {
            return;
        }

        grid[x][y] = '0';
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            Node cur = q.remove();

            for (int i = 0; i < 4; i++) {
                int newx = cur.x + dx[i];
                int newy = cur.y + dy[i];

                if (newx >= 0 && newx < grid.length && newy >= 0 && newy < grid[0].length && grid[newx][newy] == '1') {
                    grid[newx][newy] = '0';
                    q.add(new Node(newx, newy));
                }
            }
        }
    }

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
