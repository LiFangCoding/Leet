package _251_300;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * <p>
 * Example 1:
 * <p>
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * Example 2:
 * <p>
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * Example 3:
 * <p>
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * Example 4:
 * <p>
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
 */
public class _290_Word_Pattern {
    public boolean wordPattern(String s1, String s2) {
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();

        char[] chars = s1.toCharArray();
        String[] words = s2.split(" ");

        int len1 = chars.length;
        int len2 = words.length;
        if (len1 != len2) {
            return false;
        }

        for (int i = 0; i < len1; i++) {
            char c = chars[i];
            String s = words[i];

            if (map1.containsKey(c)) {
                if (!map1.get(c).equals(s)) {
                    return false;
                }
            } else {
                map1.put(c, s);
            }

            if (map2.containsKey(s)) {
                if (!map2.get(s).equals(c)) {
                    return false;
                }
            } else {
                map2.put(s, c);
            }
        }

        return true;
    }
}
