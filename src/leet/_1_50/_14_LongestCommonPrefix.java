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
    class Sol_ac_sb {
        public String longestCommonPrefix(String[] strs) {
            //vertical scan is best.
            StringBuilder sb = new StringBuilder();
            if (strs == null || strs.length == 0) {
                return sb.toString();
            }

            int len = strs[0].length();
            for (int i = 0; i < len; i++) {
                char c = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    /**
                     * idx problem
                     */
                    if (strs[j].length() <= i || strs[j].charAt(i) != c) {
                        return sb.toString();
                    }
                }

                sb.append(c);
            }

            return sb.toString();
        }
    }
}
