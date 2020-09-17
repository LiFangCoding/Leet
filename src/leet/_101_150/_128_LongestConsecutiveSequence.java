package leet._101_150;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p>
 * Your algorithm should run in O(n) complexity.
 * <p>
 * Example:
 * <p>
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class _128_LongestConsecutiveSequence {
    /**
     * 5ms
     * T = n
     * 这个优化算法与暴力算法仅有两处不同：这些数字用一个 HashSet 保存（或者用 Python 里的 Set），
     * 实现 O(1) 时间的查询，
     * 同时，我们只对 当前数字 - 1 不在哈希表里的数字，作为连续序列的第一个数字去找对应的最长序列，
     * 这是因为其他数字一定已经出现在了某个序列里。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence/solution/zui-chang-lian-xu-xu-lie-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            // important: only choose the minimum start
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
