package _301_350;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
 * <p>
 * Each 0 marks an empty land which you can pass by freely.
 * Each 1 marks a building which you cannot pass through.
 * Each 2 marks an obstacle which you cannot pass through.
 * Example:
 * <p>
 * Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
 * <p>
 * 1 - 0 - 2 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * <p>
 * Output: 7
 * <p>
 * Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
 * the point (1,2) is an ideal empty land to build a house, as the total
 *              travel distance of 3+3+1=7 is minimal. So return 7.
 * Note:
 * There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-distance-from-all-buildings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _317_Shortest_Distance_from_All_buildings {
  /**
   * 本题采用bfs的方法，记录每个起点到每个空点的距离，并且相加起来，找到最小值即可。
   *
   * @param grid
   * @return
   */
  public int shortestDistance(int[][] grid) {
    // write your code here
    int n = grid.length;
    int m = grid[0].length;
    int[][] reach = new int[n][m];
    int[][] distance = new int[n][m];
    int building = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1) {
          building++;
          boolean[][] visited = new boolean[n][m];
          Queue<node> q = new LinkedList<>();
          q.offer(new node(i, j));
          int dist = 0;
          while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
              node curr = q.poll();
              int x = curr.x;
              int y = curr.y;
              distance[x][y] += dist;
              reach[x][y]++;
              if (x > 0 && grid[x - 1][y] == 0 && !visited[x - 1][y]) {
                q.offer(new node(x - 1, y));
                visited[x - 1][y] = true;
              }
              if (x + 1 < n && grid[x + 1][y] == 0 && !visited[x + 1][y]) {
                q.offer(new node(x + 1, y));
                visited[x + 1][y] = true;
              }
              if (y > 0 && grid[x][y - 1] == 0 && !visited[x][y - 1]) {
                q.offer(new node(x, y - 1));
                visited[x][y - 1] = true;
              }
              if (y + 1 < m && grid[x][y + 1] == 0 && !visited[x][y + 1]) {
                q.offer(new node(x, y + 1));
                visited[x][y + 1] = true;
              }
            }
            dist++;
          }
        }
      }
    }

    int res = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 0 && distance[i][j] < res && reach[i][j] == building) {
          res = distance[i][j];
        }
      }
    }

    if (res == Integer.MAX_VALUE) {
      return -1;
    } else {
      return res;
    }
  }

  class node {
    int x, y;

    public node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
