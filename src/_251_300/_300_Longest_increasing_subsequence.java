package _251_300;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p>
 * Example:
 * <p>
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 * <p>
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class _300_Longest_increasing_subsequence {
    public static void main(String[] args) {
        _300_Longest_increasing_subsequence test = new _300_Longest_increasing_subsequence();
        int[] A = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(test.lengthOfLIS(A));
    }

    public int lengthOfLIS(int[] A) {
        // dp[i] means char at i, the longest increasing subsequence
        // [5, 2,3,-1,7,101]
        int[] dp = new int[A.length + 1];
        if (A == null || A.length == 0) {
            return 0;
        }

        dp[1] = 1;

        for (int i = 2; i <= A.length; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (dp[i] > dp[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = dp[1];
        for (int num : A) {
            res = Math.max(res, num);
        }
        return res;
    }
}
