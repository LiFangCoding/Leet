package leet._201_250;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * <p>
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 * <p>
 * Follow up:
 * Could you solve it in linear time?
 */
public class _239_SlidingWindowMaximum {
    /**
     * 19ms
     * T = n
     * <p>
     * 使用单调队列求解滑动窗口中的最大值。其中，单调队列是一个普通的双端队列，即队头和队尾都可以添加和弹出元素。我们假设该双端队列的 队头 是整个队列的最大元素所在下标，至 队尾 下标代表的元素值依次降低。
     * 初始时单调队列为空。随着对数组的遍历过程中，每次插入元素前，需要考察两个事情：
     * (1). 合法性检查：队头下标如果距离 i 超过了 k ，则应该出队。
     * (2). 单调性维护：如果 nums[i] 大于或等于队尾元素下标所对应的值，则当前队尾再也不可能充当某个滑动窗口的最大值了，故需要队尾出队。始终保持队中元素从队头到队尾单调递减。
     * 如次遍历一遍数组，队头就是每个滑动窗口的最大值所在下标。
     * 时间复杂度
     * 遍历中，每个元素最多进队一次，出队一次，故时间复杂度为 O(n)。
     * 空间复杂度
     * 需要额外 O(n)的空间存储单调队列。
     * <p>
     * 作者：wzc1995
     * 链接：https://www.acwing.com/solution/content/289/
     * 来源：AcWing
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int res[] = new int[n - k + 1];
        // we need to store the head and tail of queue. maintains the index which are in the sliding window now
        Deque<Integer> q = new LinkedList<>();

        int idx = 0;
        for (int i = 0; i < n; i++) {
            // remove element if the first element is out of sliding window
            if (!q.isEmpty() && i - k + 1 > q.getFirst()) {
                q.removeFirst();
            }
            // add cur into deque
            while (!q.isEmpty() && nums[i] > nums[q.getLast()])
                q.removeLast();
            q.add(i);
            if (i >= k - 1)
                res[idx++] = nums[q.getFirst()];
        }

        return res;
    }
}
