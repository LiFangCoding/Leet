package leet._251_300;

import java.util.PriorityQueue;

/**
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 * <p>
 * For example,
 * [2,3,4], the median is 3
 * <p>
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * <p>
 * Design a data structure that supports the following two operations:
 * <p>
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 *  
 * <p>
 * Example:
 * <p>
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 *  
 * <p>
 * Follow up:
 * <p>
 * If all integer numbers from the stream are between 0 and 100, how would you optimize it?
 * If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 */
public class _295_FindMedianFromDataStream {
    class MedianFinder {
        // down is max
        PriorityQueue<Integer> down;
        // up is min
        PriorityQueue<Integer> up;

        public MedianFinder() {
            up = new PriorityQueue<>();
            down = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        }

        public void addNum(int num) {
            if (down.isEmpty() || num <= down.peek()) {
                down.add(num);
                if (down.size() > up.size() + 1)
                    up.add(down.remove());
            } else {
                up.add(num);
                if (up.size() > down.size())
                    down.add(up.remove());
            }
        }

        public double findMedian() {
            if (up.size() == down.size()) {
                return (up.peek() + down.peek()) / 2.0;
            }

            return down.peek();
        }
    }

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
}
