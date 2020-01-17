package _151_200;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 * <p>
 * Input: s = "paper", t = "title"
 * Output: true
 */
public class _205_IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();

        /**
         * from s char -> t char. one -> one map
         */
        Map<Character, Character> st = new HashMap<>();
        /**
         * check if t char duplicates
         */
        Map<Character, Character> ts = new HashMap<>();

        for (int i = 0; i < len; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (st.containsKey(c1)) {
                if (st.get(c1) != c2) {
                    return false;
                }
            } else if (ts.containsKey(c2)) {
                if (ts.get(c2) != c1) {
                    return false;
                }
            } else {
                st.put(c1, c2);
                ts.put(c2, c1);
            }
        }

        return true;
    }
}
