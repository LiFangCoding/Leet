package leet._101_150;

/**
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 * <p>
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * <p>
 * Example 1:
 * <p>
 * Input: S = "rabbbit", T = "rabbit"
 * Output: 3
 * Explanation:
 * <p>
 * As shown below, there are 3 ways you can generate "rabbit" from S.
 * (The caret symbol ^ means the chosen letters)
 * <p>
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * Example 2:
 * <p>
 * Input: S = "babgbag", T = "bag"
 * Output: 5
 * Explanation:
 * <p>
 * As shown below, there are 5 ways you can generate "bag" from S.
 * (The caret symbol ^ means the chosen letters)
 * <p>
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 * ^  ^^
 * babgbag
 * ^^^
 */
public class _115_DistinctSubsequences {
    /**
     * 8ms
     * T = m * n
     * dp[i][j] means the ways that first i chars of s can form the first j chars of t
     * <p>
     * f[i][j] = f[i - 1][j - 1] (if s[i] == s[j]) + f[i-1][j]
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }

        int len1 = s.length();
        int len2 = t.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = 1;
        }
        //        no need
        //        for (int j = 1; j <= len2; j++) {
        //          dp[0][j] = 0;
        //        }

        /**
         * !!!  i, j is the ith, jth character.
         *
         * should be 1 - len.
         */
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[len1][len2];
    }
}
