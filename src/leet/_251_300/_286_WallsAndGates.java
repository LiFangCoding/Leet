package leet._251_300;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a m x n 2D grid initialized with these three possible values.
 * <p>
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 * <p>
 * Example: 
 * <p>
 * Given the 2D grid:
 * <p>
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 * 0  -1 INF INF
 * After running your function, the 2D gridwa should be:
 * <p>
 * 3  -1   0   1
 * 2   2   1  -1
 * 1  -1   2  -1
 * 0  -1   3   4
 */
public class _286_WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        int wall = -1;
        int gate = 0;
        int room = Integer.MAX_VALUE;

        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }

        int rows = rooms.length;
        int cols = rooms[0].length;

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == gate) {
                    qx.add(i);
                    qy.add(j);
                }
            }
        }

        while (!qx.isEmpty()) {
            int x = qx.remove();
            int y = qy.remove();

            for (int i = 0; i < 4; i++) {
                int newx = x + dx[i];
                int newy = y + dy[i];

                if (newx < 0 || newx >= rows || newy < 0 || newy >= cols || rooms[newx][newy] != room) {
                    continue;
                }

                rooms[newx][newy] = rooms[x][y] + 1;
                qx.add(newx);
                qy.add(newy);
            }
        }
    }
}
