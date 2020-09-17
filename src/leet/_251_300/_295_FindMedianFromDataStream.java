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
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        // -> 1.5;
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        // -> 2
        System.out.println(medianFinder.findMedian());
    }

    static class MedianFinder {
        /**
         * min is on top
         * <p>
         * <p>
         * 2 3 4 5 6
         * <p>
         * max | min
         * <p>
         * 2 3 4    5 6
         */
        PriorityQueue<Integer> minpq;
        PriorityQueue<Integer> maxpq;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            // max on top is the left part. !!!
            maxpq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
            // min on top is the right part. Confusing
            minpq = new PriorityQueue<>();
        }

        // max_top should equal or larget than 1 of min_top
        public void addNum(int num) {
            maxpq.add(num);
            minpq.add(maxpq.remove());

            if (maxpq.size() < minpq.size()) {
                maxpq.add(minpq.remove());
            }
        }

        public double findMedian() {
            if (minpq.size() == maxpq.size()) {
                return (minpq.peek() + maxpq.peek()) / 2.0;
            }

            return maxpq.peek();
        }
    }
}
