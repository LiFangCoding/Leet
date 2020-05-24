package _551_600;

import java.util.Arrays;

/**
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 * <p>
 * You need to find the shortest such subarray and output its length.
 * <p>
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * Note:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _581_Shortest_Unsorted_Continuous_Subarray {
    //TODO: more practice

    /**
     * 2ms
     * T = n
     * 线性算法的核心思路在于，将数组分为三部分，分别是起始单调递增段、中间乱序段和末尾单调递增段。
     * 需要用后两段的最小值更新起始单调递增段的结束位置，用前两段的最大值更新末尾单调递增段的起始位置。具体如下：
     * <p>
     * 从 0 开始向后找到第一个位置 st，使得 nums[st] < nums[st - 1]；若不存在，则 st = n。
     * 从 n - 1 开始向前寻找第一个位置 ed，使得 nums[ed] > nums[ed + 1]；若不存在，则 ed = -1。
     * 寻找 [0, ed] 的最大值 max_num 和 [st, n - 1] 的最小值 min_num。
     * 在 [0, st - 1] 这个单调递增的区间中找到第一个位置 new_st，使得 nums[new_st] > min_num。
     * 在 [ed + 1, n] 这个单调递增的区间中找到倒序找到第一个位置 new_ed，使得 nums[new_ed] < max_num。
     * 最终答案为 max(0, new_ed - new_st + 1)。
     * <p>
     * 作者：wzc1995
     * 链接：https://www.acwing.com/solution/LeetCode/content/458/
     * 来源：AcWing
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Sol_lineScan {
        public int findUnsortedSubarray(int[] A) {
            int len = A.length;

            int start = len;
            for (int i = 0; i < len - 1; i++) {
                if (A[i] > A[i + 1]) {
                    start = i + 1;
                    break;
                }
            }

            int end = -1;
            for (int i = len - 1; i >= 1; i--) {
                if (A[i - 1] > A[i]) {
                    end = i - 1;
                    break;
                }
            }

            int max_num = Integer.MIN_VALUE, min_num = Integer.MAX_VALUE;
            for (int i = 0; i <= end; i++) {
                max_num = Math.max(max_num, A[i]);
            }

            for (int i = start; i < len; i++) {
                min_num = Math.min(min_num, A[i]);
            }

            for (int i = 0; i < start; i++) {
                if (min_num < A[i]) {
                    start = i;
                    break;
                }
            }
            for (int i = len - 1; i > end; i--) {
                if (max_num > A[i]) {
                    end = i;
                    break;
                }
            }

            return Math.max(0, end - start + 1);
        }
    }

    /**
     * 8ms
     * T = nlogn
     */
    class Sol_Sort {
        public int findUnsortedSubarray(int[] A) {
            int len = A.length;
            int[] sorted = new int[A.length];

            for (int i = 0; i < len; i++) {
                sorted[i] = A[i];
            }

            Arrays.sort(sorted);
            int i = 0;

            while (i < len && A[i] == sorted[i]) {
                i++;
            }

            int j = len - 1;
            while (j >= 0 && A[j] == sorted[j]) {
                j--;
            }

            return Math.max(0, j - i + 1);
        }
    }
}
