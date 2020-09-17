package leet._1_50;

/**
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 * <p>
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * <p>
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */
public class _28_ImplementStrStr {
    //TODO

    /**
     * T = O(mn)
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStrBrute(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            boolean matched = true;

            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    matched = false;
                    break;
                }
            }

            if (matched) {
                return i;
            }
        }

        return -1;
    }

    //TODO

    /**
     * KMP
     * T= O(m + n)
     */
    public int strStrKMP(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if (m == 0) {
            return 0;
        }

        int[] next = new int[m];

        next[0] = -1;
        int j = -1;

        for (int i = 1; i < m; i++) {
            while (j > -1 && needle.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }
            if (needle.charAt(i) == needle.charAt(j + 1))
                j++;
            next[i] = j;
        }

        j = -1;
        for (int i = 0; i < n; i++) {
            while (j > -1 && haystack.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }

            if (haystack.charAt(i) == needle.charAt(j + 1))
                j++;
            if (j == m - 1) {
                return i - m + 1;
            }
        }
        return -1;
    }

}
