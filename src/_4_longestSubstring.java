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

public class _4_longestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        // char -> index
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;

        // [left, right]
        int left = 0;
        int right = 0;
        while (right < len) {
            char charR = s.charAt(right);

            if (map.containsKey(charR)) {
                left = Math.max(left, map.get(charR) + 1);
            }

            res = Math.max(res, right - left + 1);
            map.put(charR, right);
            right++;
        }

        return res;
    }

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
