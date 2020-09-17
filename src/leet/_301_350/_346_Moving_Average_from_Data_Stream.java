package leet._301_350;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * <p>
 * Example:
 * <p>
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/moving-average-from-data-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _346_Moving_Average_from_Data_Stream {
    class MovingAverage {
        int sum = 0, size = 0;
        Queue<Integer> q;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            q = new LinkedList<>();
            this.size = size;
        }

        public double next(int val) {
            sum += val;
            q.add(val);

            if (q.size() > size) {
                sum -= q.remove();
            }

            return (double) sum / q.size();
        }
    }
}
