package _51_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _56_MergeIntervals {
  // sort
  // TC: O( N Log N)
  // SC: O(N)
  public int[][] merge(int[][] intervals) {
    if (intervals == null || intervals.length < 2) {
      return intervals;
    }

    Arrays.sort(intervals, Comparator.comparing(interval -> interval[0]));

    List<int[]> list = new ArrayList<>();
    list.add(intervals[0]);

    for (int i = 1; i < intervals.length; i++) {
      int[] last = list.get(list.size() - 1);
      int[] cur = intervals[i];

      if (last[1] < cur[0]) {
        list.add(cur);
      } else {
        last[1] = Math.max(cur[1], last[1]);
      }
    }

    int[][] res = new int[list.size()][2];
    return list.toArray(res);
  }

  public static void main(String[] args) {
    _56_MergeIntervals test = new _56_MergeIntervals();
    int[][] intervals = new int[][] {
        {1,3},
        {2,6},
        {8,10},
        {15,18}
    };

    System.out.println(test.merge(intervals).toString());
  }
}
