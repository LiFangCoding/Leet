package _201_250;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * <p>
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class _242_Valid_Anagram {
    class Sol_map {
        public boolean isAnagram(String s, String t) {
            if (s == null || t == null) return false;
            char[] sa = s.toCharArray(), ta = t.toCharArray();
            if (sa.length != ta.length) return false;

            Map<Character, Integer> map = new HashMap<>();
            for (char c : sa) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            for (char c : ta) {
                map.put(c, map.getOrDefault(c, 0) - 1);
                if (map.get(c) < 0) return false;
            }

            return true;
        }
    }

    class Sol_array_hash {
        public boolean isAnagram(String s, String t) {
            int[] count = new int[128];

            if (s == null && t == null) {
                return true;
            }

            if (s == null || t == null) {
                return false;
            }

            if (s.length() != t.length()) {
                return false;
            }

            for (char c : s.toCharArray()) {
                count[c]++;
            }

            for (char c : t.toCharArray()) {
                count[c]--;
            }

            for (int num : count) {
                if (num != 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
