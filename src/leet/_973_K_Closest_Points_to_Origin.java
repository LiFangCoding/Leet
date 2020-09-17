package leet;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * <p>
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * <p>
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 * <p>
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 *  
 * <p>
 * Note:
 * <p>
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 */
public class _973_K_Closest_Points_to_Origin {
    // TODO: partition need more think. Bug
    class Sol_Partition {
        public int[][] kClosest(int[][] points, int k) {
            int len = points.length;
            partition(points, 0, len - 1, k);
            return Arrays.copyOfRange(points, 0, k);
        }

        private void partition(int[][] points, int l, int r, int k) {
            if (l >= r) {
                return;
            }

            int pivot = dis(points[l]);

            int i = l + 1;
            // j will be partion idx
            int j = r;
            while (true) {
                while (i < j && dis(points[i]) < pivot) {
                    i++;
                }

                while (i < j && dis(points[j]) > pivot) {
                    j--;
                }

                if (i >= j) {
                    break;
                }

                swap(points, l++, r--);
            }

            swap(points, l, j);

            if (j == k) {
                return;
            } else if (j < k) {
                partition(points, j + 1, r, k);
            } else {
                partition(points, l, j - 1, k);
            }
        }

        private void swap(int[][] points, int i, int j) {
            int[] temp = points[i];
            points[i] = points[j];
            points[j] = temp;
        }

        private int dis(int[] point) {
            int x = point[0];
            int y = point[1];
            return x * x + y * y;
        }
    }

    class Sol_PQ {
        public int[][] kClosest(int[][] points, int K) {
            // get min. Use maxPq
            PriorityQueue<int[]> maxPq = new PriorityQueue<>((x, y) -> Integer.compare(dis(y), dis(x)));

            for (int[] p : points) {
                // here not points.length == 2. It is point
                if (p != null && p.length == 2) {
                    maxPq.add(p);
                }

                if (maxPq.size() > K) {
                    maxPq.remove();
                }
            }

            // incompatible types: int[] cannot be converted to int. int[][] not int[]. Here new int[K][2] not new int[K]
            int[][] ans = new int[K][2];
            int idx = K - 1;
            while (!maxPq.isEmpty()) {
                ans[idx--] = maxPq.remove();
            }

            return ans;
        }

        private int dis(int[] point) {
            int x = point[0];
            int y = point[1];
            return x * x + y * y;
        }
    }
}
