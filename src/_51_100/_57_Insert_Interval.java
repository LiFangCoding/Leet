package _51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
public class _57_Insert_Interval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        /**
         * careful. When intervals are empty, just add newInterval inside.
         */
        if (intervals == null) {
            return new int[][]{newInterval};
        }
        List<int[]> list = new ArrayList<>();

        int len = intervals.length;
        int i = 0;
        // skip (and add to output) all intervals that come before the 'newInterval'
        while (i < len && intervals[i][1] < newInterval[0])
            list.add(intervals[i++]);

        // merge all intervals that overlap with 'newInterval'
        // For overlap, only four conditions. It is just the end and start relationship
        while (i < len && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        // insert the newInterval
        list.add(newInterval);

        // add all the remaining intervals to the output
        while (i < len)
            list.add(intervals[i++]);

        int[][] res = new int[list.size()][2];
        return list.toArray(res);
    }
}
