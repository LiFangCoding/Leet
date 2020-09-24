package leet._251_300;

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
    public boolean wordPattern(String pattern, String str) {
        // hash map to determine a1, a2 -> b1. map (b1, a1)
        // a1 -> b1, b2   map(a1, b1)
        String[] words = str.split(" ");

        if (pattern.length() != words.length) return false;

        Map<Character, String> pw = new HashMap<>();
        Map<String, Character> wp = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char a = pattern.charAt(i);
            String b = words[i];

            if (pw.containsKey(a) && !pw.get(a).equals(b)) return false;
            pw.put(a, b);

            if (wp.containsKey(b) && wp.get(b) != a) return false;
            wp.put(b, a);
        }

        return true;
    }
}
