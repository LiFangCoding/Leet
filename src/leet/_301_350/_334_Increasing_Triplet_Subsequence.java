package leet._301_350;

import java.util.Arrays;

/**
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * <p>
 * Formally the function should:
 * <p>
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: true
 * Example 2:
 * <p>
 * Input: [5,4,3,2,1]
 * Output: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-triplet-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _334_Increasing_Triplet_Subsequence {
    // 最长上升子序列。 当前每个长度的结尾最小值 q[k]
    // 找到q[k] >= ai第一个数一个树， q[k - 1]是<的最后一个数
    // ai <= q[k], q[k] 变为q[k]
    // 因为只为3. 长度为1末尾最小值， 长度为2末尾最小值。 q数组长度变为2. 复杂度变为O(1)
    public boolean increasingTriplet(int[] nums) {
        int[] q = new int[2];
        Arrays.fill(q, Integer.MAX_VALUE);

        for (int a : nums) {
            int k = 2;
            while (k > 0 && q[k - 1] >= a) {
                k--;
            }
            // now k is the first one >= a
            if (k == 2) return true;
            q[k] = a;
        }
        return false;
    }
}
