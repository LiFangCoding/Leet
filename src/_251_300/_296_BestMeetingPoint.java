package _251_300;

import java.util.ArrayList;
import java.util.List;

/**
 * A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1 - 0 - 0 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * <p>
 * Output: 6
 * <p>
 * Explanation: Given three people living at (0,0), (0,4), and (2,2):
 *              The point (0,2) is an ideal meeting point, as the total travel distance
 *              of 2+2+2=6 is minimal. So return 6.
 */
public class _296_BestMeetingPoint {
  public int minTotalDistance(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
      return 0;
    }

    List<Integer> xlist = new ArrayList<>();
    for (int x = 0; x < grid.length; x++) {
      for (int y = 0; y < grid[0].length; y++) {
        if (grid[x][y] == 1) {
          xlist.add(x);
        }
      }
    }

    List<Integer> ylist = new ArrayList<>();
    for (int y = 0; y < grid[0].length; y++) {
      for (int x = 0; x < grid.length; x++) {
        if (grid[x][y] == 1) {
          ylist.add(y);
        }
      }
    }

    int xnear = xlist.get(xlist.size() / 2);
    int ynear = ylist.get(ylist.size() / 2);

    int ans = 0;
    for (int x : xlist) {
      ans += Math.abs(xnear - x);
    }

    for (int y : ylist) {
      ans += Math.abs(ynear - y);
    }

    return ans;
  }
}
