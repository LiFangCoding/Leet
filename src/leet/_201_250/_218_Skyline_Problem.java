package leet._201_250;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).
 * <p>
 * <p>
 * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 * <p>
 * For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
 * <p>
 * The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.
 * <p>
 * For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
 * <p>
 * Notes:
 * <p>
 * The number of buildings in any input list is guaranteed to be in the range [0, 10000].
 * The input list is already sorted in ascending order by the left x position Li.
 * The output list must be sorted by the x position.
 * There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
 */
public class _218_Skyline_Problem {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(5);
        pq.add(5);
        pq.add(10);

        System.out.println("pq is " + pq);
        pq.remove(5);
        System.out.println("new pq is " + pq);
    }

    class Sol_Acwing {
        public List<List<Integer>> getSkyline(int[][] buildings) {
            List<List<Integer>> res = new ArrayList<>();

            List<int[]> points = new ArrayList<>();
            for (int[] b : buildings) {
                // left, point is x, -h
                // right, point is x, h
                points.add(new int[] { b[0], -b[2] });
                points.add(new int[] { b[1], b[2] });
            }

            Collections.sort(points, (x, y) -> {
                if (x[0] != y[0])
                    return Integer.compare(x[0], y[0]);
                else
                    return Integer.compare(x[1], y[1]);
            });

            PriorityQueue<Integer> heights = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
            heights.add(0);

            for (int[] p : points) {
                int x = p[0], h = Math.abs(p[1]);
                // left
                if (p[1] < 0) {
                    if (h > heights.peek()) {
                        res.add(Arrays.asList(x, h));
                    }
                    // do not forget
                    heights.add(h);
                } else { // right
                    heights.remove(h);
                    if (h > heights.peek()) {
                        res.add(Arrays.asList(x, heights.peek()));
                    }
                }
            }

            return res;
        }
    }

    class Sol_old {
        //TODO: add the skyline problem
        List<List<Integer>> res = new ArrayList<>();

        List<int[]> points = new ArrayList<>();

        public List<List<Integer>> getSkyline(int[][] buildings) {
            if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
                return res;
            }

            for (int[] building : buildings) {
                // [[2,9,10]...]
                // 左顶点存为负数
                points.add(new int[] { building[0], -building[2] });
                // 右顶点存为正数
                points.add(new int[] { building[1], building[2] });
            }

            // 根据横坐标对列表排序，相同横坐标的点纵坐标小的排在前面
            Collections.sort(points, (x, y) -> {
                if (x[0] != y[0])
                    return Integer.compare(x[0], y[0]);
                else
                    return Integer.compare(x[1], y[1]);
            });

            // 构建大根堆，按照纵坐标来判断大小, 堆顶放最大height
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b.compareTo(a));
            int preHeight = 0;
            pq.offer(preHeight);
            for (int[] point : points) {
                if (point[1] < 0) {
                    // 将左顶点加入堆中
                    pq.offer(-point[1]);
                } else {
                    // 将右顶点对应的左顶点移去
                    pq.remove(point[1]);
                }

                Integer currMaxHeight = pq.peek();
                if (currMaxHeight != preHeight) {
                    // 如果堆的新顶部和上个height高度不一样，说明有高度差，则加入一个新的height
                    res.add(Arrays.asList(point[0], currMaxHeight));
                    preHeight = currMaxHeight;
                }
            }

            return res;
        }
    }
}
