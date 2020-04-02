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
        if (A == null || A.length == 0) {
            return 0;
        }


        int[] f = new int[A.length];
        // better to define 1
        int ans = 1;

        for (int i = 0; i < A.length; i++) {
            f[i] = 1;
            // get value for f[i]
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
        }

        return ans;
    }
}
