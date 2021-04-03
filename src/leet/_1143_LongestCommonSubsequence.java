package leet;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 *
 * A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
 *
 *  
 *
 * If there is no common subsequence, return 0.
 *
 *  
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *  
 *
 * Constraints:
 *
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * The input strings consist of lowercase English characters only.
 */
public class _1143_LongestCommonSubsequence {
    public int longestCommonSubsequence(String s1, String s2) {
        // f[i][j] means [0, i - 1], [0, j - 1] the longest commmon sub
        // f[0][j] = 0, f[i][0] = 0
        // f[i][j] = max (f[i - 1][j - 1] + 1 if c1 == c2, f[i - 1][j], f[i][j - 1])

        int m = s1.length(), n = s2.length();
        int[][] f = new int[m + 1][n + 1];
        int res = 0;

        for (int i = 1; i <= m; i++) {
            char c1 = s1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = s2.charAt(j - 1);
                if (c1 == c2) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j],f[i][j - 1]);
                }
                res = Math.max(res, f[i][j]);
            }
        }

        return res;
    }
}
