package leet._1_50;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 * <p>
 * All given inputs are in lowercase letters a-z.
 */
public class _14_LongestCommonPrefix {
    //TODO
    class Sol_ac_sb {
        public String longestCommonPrefix(String[] A) {
            //vertical scan is best.
            // Because at least each character need to scan one time.
            if (A == null || A.length == 0) {
                return "";
            }

            StringBuilder sb = new StringBuilder();
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
                        return sb.toString();
                    }
                }

                sb.append(c);
            }

            return sb.toString();
        }
    }

    class Sol_no_sb {
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
}