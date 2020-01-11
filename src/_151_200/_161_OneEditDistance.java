package _151_200;

/**
 * Given two strings s and t, determine if they are both one edit distance apart.
 * <p>
 * Note: 
 * <p>
 * There are 3 possiblities to satisify one edit distance apart:
 * <p>
 * Insert a character into s to get t
 * Delete a character from s to get t
 * Replace a character of s to get t
 * Example 1:
 * <p>
 * Input: s = "ab", t = "acb"
 * Output: true
 * Explanation: We can insert 'c' into s to get t.
 * Example 2:
 * <p>
 * Input: s = "cab", t = "ad"
 * Output: false
 * Explanation: We cannot get t from s by only one step.
 * Example 3:
 * <p>
 * Input: s = "1203", t = "1213"
 * Output: true
 * Explanation: We can replace '0' with '1' to get t.
 */
public class _161_OneEditDistance {
    /**
     * f(i, i + 1) = other ith chars are same
     * f(i + 1, i)  ith chars are same
     * (i, i) means the all are same
     * <p>
     * f(m ,n) = if last equals, f(m - 1, n - 1)
     * if not equal,
     */
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        /**
         * s should always larger
         */
        if (s.length() < t.length()) {
            String temp = s;
            s = t;
            t = s;
        }

        int slen = s.length();
        int tlen = t.length();

        if ((slen - tlen) > 1) {
            return false;
        }


    }
}
