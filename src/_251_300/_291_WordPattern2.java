package _251_300;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.
 * <p>
 * Example 1:
 * <p>
 * Input: pattern = "abab", str = "redblueredblue"
 * Output: true
 * Example 2:
 * <p>
 * Input: pattern = pattern = "aaaa", str = "asdasdasdasd"
 * Output: true
 * Example 3:
 * <p>
 * Input: pattern = "aabb", str = "xyzabcxzyabc"
 * Output: false
 * Notes:
 * You may assume both pattern and str contains only lowercase
 */
public class _291_WordPattern2 {
  // 2ms
  class Sol1 {
    Map<Character, String> map = new HashMap<>();

    public boolean wordPatternMatch(String pattern, String str) {
      if (pattern == null || str == null) {
        return pattern == str;
      }

      return wordMatch(pattern,0, str, 0);
    }

    private boolean wordMatch(String pattern, int l, String str, int r) {
      if (l == pattern.length() || r == str.length()) {
        return l == pattern.length() && r == str.length();
      }

      char c = pattern.charAt(l);

      // The for loop i <= str.length() - pattern.length() + l + 1 is huge improvement
      // from 76ms -> 2ms
      for (int i = r + 1; i <= str.length() - pattern.length() + l + 1; i++) {
        String choice = str.substring(r, i);

        if (!map.containsKey(c) && !map.containsValue(choice)) {
          map.put(c, choice);
          if (wordMatch(pattern, l + 1, str, i)) {
            return true;
          }
          map.remove(c);
        }

        else if (map.containsKey(c) && map.get(c).equals(choice)) {
          return wordMatch(pattern, l + 1, str, i);
        }
      }

      return false;
    }
  }
  /**
   * 67 ms
   */
  class Sol2 {
      Map<Character, String> map1 = new HashMap<>();
      Map<String, Character> map2 = new HashMap<>();

      public boolean wordPatternMatch(String pattern, String str) {
        if (pattern == null || str == null) {
          return pattern == str;
        }

        if (pattern.length() == 0 || str.length() == 0) {
          return pattern.length() == str.length();
        }

        return wordMatch(pattern,0, str, 0);
      }

      private boolean wordMatch(String pattern, int l, String str, int r) {
        if (l == pattern.length() || r == str.length()) {
          return l == pattern.length() && r == str.length();
        }

        char c = pattern.charAt(l);

        for (int i = r + 1; i <= str.length(); i++) {
          String choice = str.substring(r, i);

          // consider valid condition
          if (map1.containsKey(c) && map1.get(c).equals(choice) && map2.containsKey(choice) && map2.get(choice) == c) {
            return wordMatch(pattern, l + 1, str, i);
          }

          if (!map1.containsKey(c) && !map2.containsKey(choice)) {
            map1.put(c, choice);
            map2.put(choice, c);

            if (wordMatch(pattern, l + 1, str, i)) {
              return true;
            }

            map1.remove(c);
            map2.remove(choice);
          }
        }

        return false;
      }
    }

    public static void main(String[] args) {
        String s = "abc";
        char c = 'd';
        String d = s + c;
    }
}
