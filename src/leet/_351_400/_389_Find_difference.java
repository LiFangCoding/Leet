package leet._351_400;

import java.util.HashMap;
import java.util.Map;

public class _389_Find_difference {
    class Sol_xor {
        public char findTheDifference(String s, String t) {
            int x = 0;
            for (char c : s.toCharArray())
                x ^= c;
            for (char c : t.toCharArray())
                x ^= c;
            return (char) x;
        }
    }

    class Solution_map {
        public char findTheDifference(String s, String t) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : t.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            for (char c : s.toCharArray()) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) - 1);
                }
            }

            for (char c : map.keySet()) {
                if (map.get(c) > 0) {
                    return c;
                }
            }

            return '0';
        }
    }
}
