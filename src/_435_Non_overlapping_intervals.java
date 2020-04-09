import java.util.Arrays;

public class _435_Non_overlapping_intervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int total = 0;
        int prev = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < prev) {
                ++total;
            } else {
                prev = intervals[i][1];
            }
        }

        return total;
    }
}
