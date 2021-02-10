package leet;

/**
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
 *
 * Example 1:
 *
 * Input:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * Output: 3
 * Explanation:
 * The repeated subarray with maximum length is [3, 2, 1].
 *
 * Note:
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _718_Maximum_Length_Of_Repeated_Subarray {
    // 最长重复子序列
    // 不需要具体的子矩阵是什么，所以可以考虑dp. 一个集合的最值属性
    // dp[i][j] is the end at ith array and end at B[j - 1]
    // the largest subarray len
    // T = n * m
    class Sol_dp {
        public int findLength(int[] A, int[] B) {
            int lenA = A.length;
            int lenB = B.length;
            int res = 0;
            // dp[i][j] = [i] == [j] ? dp[i - 1][j - 1] + 1 : (ai == bj 1 : 0)
            // has i - 1, j - 1, so i, j from 1

            int[][] dp = new int[lenA + 1][lenB + 1];
            for (int i = 1; i <= lenA; i++) {
                for (int j = 1; j <= lenB; j++) {
                    if (A[i - 1] == B[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        res = Math.max(dp[i][j], res);
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }

            return res;
        }
    }

    // T = n ^ 3
    class Sol_brute_force {
        public int findLength(int[] A, int[] B) {
            int lenA = A.length;
            int lenB = B.length;
            int res = 0;

            for (int i = 0; i < lenA; i++) {
                for (int j = 0; j < lenB; j++) {
                    if (B[j] == A[i]) {
                        // continue to find the subarray
                        int k = j, u = i;
                        while (k < lenB && u < lenA) {
                            if (B[k] == A[u]) {
                                k++;
                                u++;
                            } else {
                                break;
                            }
                        }
                        // k is the idx not same
                        int len = k - j;
                        res = Math.max(res, len);
                    }
                }
            }

            return res;
        }
    }
}
