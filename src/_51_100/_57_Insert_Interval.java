package _51_100;

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
  /**
   * 3ms
   * T = n
   */
  class Sol_jiuzhang_freq {
    public int[][] insert(int[][] intervals, int[] newInterval) {
      List<int[]> ansList = new ArrayList<>();
      List<int[]> list = new ArrayList<>();

      int idx = 0;
      int len = intervals.length;

      while (idx < len && intervals[idx][0] < newInterval[0]) {
        list.add(intervals[idx]);
        idx++;
      }

      list.add(newInterval);
      while (idx < len) {
        list.add(intervals[idx]);
        idx++;
      }

      int[] last = null;
      for (int[] item : list) {
        if (last == null || last[1] < item[0]) {
          ansList.add(item);
          last = item;
        } else {
          last[1] = Math.max(last[1], item[1]);
        }
      }

      int[][] ans = new int[ansList.size()][2];
      for (int i = 0; i < ansList.size(); i++) {
        ans[i] = ansList.get(i);
      }

      return ans;
    }
  }

  /**
   * T = n
   * More easy to implement
   */
  public int[][] insert(int[][] intervals, int[] newInterval) {
    /**
     * careful. When intervals are empty, just add newInterval inside.
     */
    if (intervals == null || intervals.length == 0) {
      return new int[][] { newInterval };
    }

    List<int[]> ans = new ArrayList<>();

    int len = intervals.length;
    int i = 0;
    // skip (and add to output) all intervals that come before the 'newInterval'
    while (i < len && intervals[i][1] < newInterval[0])
      ans.add(intervals[i++]);

    // merge all intervals that overlap with 'newInterval'
    // For overlap, only four conditions. It is just the end and start relationship
    while (i < len && intervals[i][0] <= newInterval[1]) {
      newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
      newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
      i++;
    }

    // insert the newInterval
    ans.add(newInterval);

    // add all the remaining intervals to the output
    while (i < len)
      ans.add(intervals[i++]);

    int[][] res = new int[ans.size()][2];
    return ans.toArray(res);
  }

  /**
   * 2ms
   * T = logn + consecutive
   */
  class Sol_Binary_Search {
    public int[][] insert(int[][] intervals, int[] newInterval) {
      List<int[]> ansList = new ArrayList<>();

      if (intervals == null || intervals.length == 0) {
        int[][] ans = new int[1][2];
        ans[0] = newInterval;
        return ans;
      }

      int idx = find(intervals, newInterval);
      // System.out.println("the idx : " + idx);
      for (int i = 0; i < idx; i++) {
        ansList.add(intervals[i]);
      }

      if (intervals[idx][0] < newInterval[0]) {
        ansList.add(intervals[idx]);
        if (intervals[idx][1] < newInterval[0]) {
          ansList.add(newInterval);
        } else {
          int[] last = ansList.get(ansList.size() - 1);
          last[1] = Math.max(last[1], newInterval[1]);
        }
      } else {
        ansList.add(newInterval);
        if (newInterval[1] < intervals[idx][0]) {
          ansList.add(intervals[idx]);
        } else {
          int[] last = ansList.get(ansList.size() - 1);
          last[1] = Math.max(last[1], intervals[idx][1]);
        }
      }

      for (int i = idx + 1; i < intervals.length; i++) {
        int[] last = ansList.get(ansList.size() - 1);
        if (last[1] < intervals[i][0]) {
          ansList.add(intervals[i]);
        } else {
          last[1] = Math.max(last[1], intervals[i][1]);
        }
      }

      int[][] ans = new int[ansList.size()][2];
      for (int i = 0; i < ansList.size(); i++) {
        ans[i] = ansList.get(i);
      }
      return ans;
    }

    // find the last position < new Interval start. then merge interval
    private int find(int[][] intervals, int[] inter) {
      if (intervals == null || intervals.length == 0) {
        return 0;
      }

      int l = 0, r = intervals.length - 1;

      while (l + 1 < r) {
        int mid = l + (r - l) / 2;
        if (intervals[mid][0] > inter[0]) {
          r = mid;
        } else if (intervals[mid][0] == inter[0]) {
          return mid;
        } else {
          l = mid;
        }
      }

      if (intervals[r][0] <= inter[0]) {
        return r;
      }

      return l;
    }
  }
}
