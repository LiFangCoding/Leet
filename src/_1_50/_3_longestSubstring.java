package _1_50;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class _3_longestSubstring {
    /**
     * T = O(n)
     * S = O(n)
     */
    public int lengthOfLongestSubstring(String s) {
        // here is val -> idx
        Map<Character, Integer> map = new HashMap<>();
        char[] sa = s.toCharArray();
        int res = 0;
        for (int i = 0, j = 0; i < sa.length; i++) {
            if (map.containsKey(sa[i])) {
                j = Math.max(map.get(sa[i]) + 1, j);
            }
            map.put(sa[i], i);
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    class Sol_ac {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>();
            char[] sa = s.toCharArray();
            int res = 0;
            for (int i = 0, j = 0; i < sa.length; i++) {
                map.put(sa[i], map.getOrDefault(sa[i], 0) + 1);
                while (map.get(sa[i]) > 1) {
                    map.put(sa[j], map.get(sa[j]) - 1);
                    j++;
                }
                res = Math.max(res, i - j + 1);
            }
            return res;
        }
    }
}
