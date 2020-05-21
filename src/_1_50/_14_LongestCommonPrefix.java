package _1_50;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 */
public class _14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] A) {
        //vertical scan is best.
        // Because at least each character need to scan one time.
        if (A == null || A.length == 0) {
            return "";
        }

        StringBuilder res = new StringBuilder();
        int strLen = A[0].length();

        /**
         * vertical index i from 0 to longestcommonlen
         */
        for (int i = 0; i < strLen; i++) {
            char c = A[0].charAt(i);
            for (int j = 1; j < A.length; j++) {
                /**
                 * Make sure the index is not out of index.
                 * If the index is the maximum length, then this is the result.
                 */
                if (i == A[j].length() || A[j].charAt(i) != c) {
                    return res.toString();
                }
            }

            res.append(c);
        }

        return res.toString();
    }

    /**
     * shorter version
     */
    public String longestCommonPrefix2(String[] strs) {
        //vertical scan is best.
        // Because at least each character need to scan one time.
        if (strs == null || strs.length == 0) {
            return "";
        }

        int strLen = strs[0].length();

        /**
         * vertical index i from 0 to longestcommonlen
         */
        for (int i = 0; i < strLen; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                /**
                 * Make sure the index is not out of index.
                 * If the index is the maximum length, then this is the result.
                 */
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }
}
