package leet._251_300;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 * <p>
 * Example 1:
 * <p>
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [[7,10],[2,4]]
 * Output: 1
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class _253_Meeting_Room2 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(intervals.length, (a, b) -> Integer.compare(a, b));
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        // Add the first meeting
        pq.add(intervals[0][1]);

        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            // If the room due to free up the earliest is free, assign that room to this meeting.
            if (intervals[i][0] >= pq.peek()) {
                pq.remove();
            }

            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            pq.add(intervals[i][1]);
        }

        // The size of the heap tells us the minimum rooms required for all the meetings.
        return pq.size();
    }
}
