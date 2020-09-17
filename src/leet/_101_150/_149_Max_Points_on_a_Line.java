package leet._101_150;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1],[2,2],[3,3]]
 * Output: 3
 * Explanation:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 * Example 2:
 * <p>
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * Explanation:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 */
public class _149_Max_Points_on_a_Line {
    public static void main(String[] args) {
        int[][] points = { { 1, 1 }, { 3, 2 }, { 5, 3 }, { 4, 1 }, { 2, 3 }, { 1, 4 } };
        _149_Max_Points_on_a_Line test = new _149_Max_Points_on_a_Line();
        System.out.println(test.maxPoints_my(points));
    }

    public int maxPoints_my(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        int n = points.length;
        int ans = 1;

        // can have [[0,0],[1,1],[0,0]]
        for (int i = 0; i < n; i++) {
            // slope -> cnt
            Map<Double, Integer> map = new HashMap<>();
            // careful include itself
            int vertCnt = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (points[j][0] == points[i][0]) {
                    vertCnt++;
                    System.out.println("verCnt is " + vertCnt);
                    ans = Math.max(ans, vertCnt);
                    System.out.println("ans is " + ans);

                } else {
                    double slope = getSlope(points[i], points[j]);
                    System.out.println("Points are " + points[i][0] + "," + points[i][1] + " " + points[j][0] + "," + points[j][1] + " slope is " + slope);
                    map.put(slope, map.getOrDefault(slope, 1) + 1);
                    System.out.println("map count is " + map.get(slope));
                    ans = Math.max(ans, map.get(slope));
                    System.out.println("ans is " + ans);
                }
            }
        }

        return ans;
    }

    private double getSlope(int[] p1, int[] p2) {
        // System.out.println("p1 x is " + p1[0] + " y is " + p1[1]);
        // System.out.println("p2 x is " + p2[0] + " y is " + p2[1]);

        return (double) (p2[1] - p1[1]) / (p2[0] - p1[0]);
    }

    //TODO: need more practice
    public int maxPoints(int[][] points) {
        // Write your code here
        if (points == null) {
            return 0;
        }
        int ans = 0;

        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slope = new HashMap<>();
            // because can have the overlap points. [[1,1],[1,1],[2,2],[2,2]] ans = 4
            int maxPoints = 0, overlap = 0, vertical = 0;

            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] == points[j][0]) {
                    if (points[i][1] == points[j][1]) {
                        overlap++;
                    } else {
                        vertical++;
                    }
                    continue;
                }
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                int tmp = gcd(dx, dy);
                dx /= tmp;
                dy /= tmp;
                String k = dy + "/" + dx;

                if (!slope.containsKey(k)) {
                    slope.put(k, 0);
                }
                slope.put(k, slope.get(k) + 1);
                maxPoints = Math.max(maxPoints, slope.get(k));
            }

            maxPoints = Math.max(maxPoints, vertical);
            ans = Math.max(ans, maxPoints + overlap + 1);
        }

        return ans;
    }

    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
