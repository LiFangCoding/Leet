package _1_50;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();
        // c -> index
        Map<Character, Integer> map = new HashMap();
        int ans = 0;

        for (int l = 0, r = 0; r < s.length(); r++) {
            if (!map.containsKey(chars[r])) {
                map.put(chars[r], r);
            } else {
                // here "abba". When last a comes, map.get(a) will make l to be 1 which is incorrect
                // Make l do not go back
                // Important
                l = Math.max(l, map.get(chars[r]) + 1);
                map.put(chars[r], r);
            }

            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }

    /**
     * T = O(n) But a little slower since it will remove 1 by 1, many times. For above method, just 1 time.
     * S = O(n)
     */
    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        Set<Character> set = new HashSet<>();
        int res = 0;

        // [left, right)
        int left = 0;
        int right = 0;
        while (right < len) {
            char charR = s.charAt(right);

            if (set.contains(charR)) {
                set.remove(s.charAt(left++));
            } else {
                set.add(charR);
                right++;
                res = Math.max(res, right - left);
            }
        }

        return res;
    }
}
