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
        PriorityQueue<Integer> min;
        PriorityQueue<Integer> max;

        public MedianFinder() {
            min = new PriorityQueue<>();
            max = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        }

        public void addNum(int num) {
            if (max.isEmpty() || num <= max.peek()) {
                max.add(num);
                if (max.size() > min.size() + 1)
                    min.add(max.remove());
            } else {
                min.add(num);
                if (min.size() > max.size())
                    max.add(min.remove());
            }
        }

        public double findMedian() {
            if (max.size() == min.size()) {
                return (max.peek() + min.peek()) / 2.0;
            }

            return max.peek();
        }
    }

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
}
