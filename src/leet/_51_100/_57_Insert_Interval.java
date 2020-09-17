package leet._51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 * <p>
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
public class _57_Insert_Interval {
    //TODO

    /**
     * 2ms
     * T = n
     * 对于新区间左边和右边的、与新区间没有重叠的区间，直接将它们按顺序插入；
     * 对于与新区间相交的区间，我们维护合并后区间的左端点和右端点，最后再将合并后的区间插入适当的位置。
     * <p>
     * 时间复杂度分析：每个区间只会遍历一次，所以总时间复杂度是 O(n).
     * https://www.acwing.com/solution/content/132/
     */
    class Sol_scan {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> ansList = new ArrayList<>();
            boolean hasIn = false;

            for (int[] interval : intervals) {
                if (interval[0] > newInterval[1]) {
                    if (!hasIn) {
                        ansList.add(newInterval);
                        hasIn = true;
                    }
                    ansList.add(interval);
                } else if (interval[1] < newInterval[0]) {
                    ansList.add(interval);
                } else {
                    newInterval[0] = Math.min(newInterval[0], interval[0]);
                    newInterval[1] = Math.max(newInterval[1], interval[1]);
                }
            }

            /**
             * []
             * [5,7]
             */
            if (!hasIn) {
                ansList.add(newInterval);
            }

            int[][] ans = new int[ansList.size()][2];
            return ansList.toArray(ans);
        }
    }
}
