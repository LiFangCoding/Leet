package _151_200;

import java.util.HashMap;

/**
 * Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "eceba"
 * Output: 3
 * Explanation: t is "ece" which its length is 3.
 * Example 2:
 * <p>
 * Input: "ccaabbb"
 * Output: 5
 * Explanation: t is "aabbb" which its length is 5.
 */
public class _159_LongestSubstringwithAtMostTwoDistinctCharacters {
    public static void main(String[] args) {
        _159_LongestSubstringwithAtMostTwoDistinctCharacters test = new _159_LongestSubstringwithAtMostTwoDistinctCharacters();
        System.out.println(test.lengthOfLongestSubstringTwoDistinct("eceba"));

        System.out.println(test.lengthOfLongestSubstringTwoDistinct("ccaabbb"));
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int len = chars.length;
        int res = 0;

        /**
         * Sliding window left and right pointers
         */
        int left = 0;
        int right = 0;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        while (right < len) {
            map.put(chars[right], map.getOrDefault(chars[right], 0) + 1);

            while (left < right && map.size() > 2) {
                map.put(chars[left], map.get(chars[left]) - 1);
                if (map.get(chars[left]) == 0) {
                    map.remove(chars[left]);
                }
                left++;
            }

            res = Math.max(res, right - left + 1);
            /**
             * !!! important
             */
            right++;
        }

        return res;
    }
}
