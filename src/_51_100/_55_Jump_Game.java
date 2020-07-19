package _51_100;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * <p>
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 3 * 10^4
 * 0 <= nums[i][j] <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _55_Jump_Game {
    class Sol_dp {
        /**
         * Dynamic Programming
         * O(n^2)
         *
         * @param A
         * @return
         */
        public boolean canJump_dp(int[] A) {
            if (A == null || A.length == 0) {
                return false;
            }

            int len = A.length;
            boolean[] f = new boolean[len];
            f[0] = true;

            for (int i = 1; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    if (f[j] && j + A[j] >= i) {
                        f[i] = true;
                        break;
                    }
                }
            }

            return f[len - 1];
        }
    }

    class Sol_greedy {
        /**
         * Greedy
         * O(n)
         *
         * @return
         */
        public boolean canJump_greedy(int[] A) {
            // think it as merging n intervals
            if (A == null || A.length == 0) {
                return false;
            }
            int farthest = A[0];
            for (int i = 1; i < A.length; i++) {
                if (i > farthest) {
                    return false;
                }
                if (i <= farthest && A[i] + i >= farthest) {
                    farthest = A[i] + i;
                }
            }
            return farthest >= A.length - 1;
        }
    }
}
