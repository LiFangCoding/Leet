package _251_300;

import java.util.Arrays;

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
        // f[i] means char at i, the longest increasing subsequence
        // [5, 2,3,-1,7,101]
        int[] f = new int[A.length];
        Arrays.fill(f, 1);

        //!!! pay attention to the i, j index here
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < i; j++) {
                // Here, important is the A here
                if (A[i] > A[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }

        return Arrays.stream(f).max().getAsInt();
    }
}
