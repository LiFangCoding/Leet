package leet._401_450;

import java.util.HashMap;
import java.util.Map;

public class _409_Longest_Palindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        for (char c : map.keySet()) {
            res += map.get(c) / 2 * 2;
        }

        if (res < s.length()) res++;
        return res;
    }
}
