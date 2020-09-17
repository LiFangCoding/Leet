package leet;

import java.util.LinkedList;
import java.util.Queue;

public class _994_Rotting_Oranges {
    int empty = 0;
    int fresh = 1;
    int rotten = 2;
    int[] dx = new int[] { -1, 1, 0, 0 };
    int[] dy = new int[] { 0, 0, -1, 1 };

    public int orangesRotting(int[][] grid) {
        // for the rotten one, bfs to find when all the rottens
        int rows = grid.length, cols = grid[0].length;

        int freshCnt = 0;
        // bfs needs q and marked to avoid go back in grid.
        Queue<int[]> q = new LinkedList<>();
        // no need marked. Explore will only go to the fresh

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                if (grid[x][y] == rotten) {
                    q.add(new int[]{x, y});
                } else if (grid[x][y] == fresh) {
                    freshCnt++;
                }
            }
        }

        // [0] exp: 0
        if (freshCnt == 0) {
            return 0;
        }

        int level = -1;
        while (!q.isEmpty()) {
            level++;

            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.remove();
                int x = cur[0], y = cur[1];

                for (int k = 0; k < 4; k++) {
                    int newx = x + dx[k];
                    int newy = y + dy[k];

                    if (newx < 0 || newx >= rows || newy < 0 || newy >= cols) {
                        continue;
                    }

                    if (grid[newx][newy] == fresh) {
                        grid[newx][newy] = rotten;
                        q.add(new int[]{newx, newy});
                        freshCnt--;

                        if (freshCnt == 0) {
                            return level + 1;
                        }
                    }
                }
            }
        }

        return -1;
    }
}
