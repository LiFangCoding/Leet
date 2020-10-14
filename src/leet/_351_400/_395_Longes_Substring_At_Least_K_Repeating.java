package leet._351_400;

import java.util.HashMap;
import java.util.Map;

public class _395_Longes_Substring_At_Least_K_Repeating {
    class Solution {
        // 有多少不同字符的数量
        // 有多少字符满足要求 >= k

        int K;
        int x;
        int y;

        Map<Character, Integer> map = new HashMap<>();

        void add(char c) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                x++;
            }
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == K) y++;
        }

        void del(char c) {
            if (map.get(c) == K) y--;
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                x--;
            }
        }

        public int longestSubstring(String s, int _K) {
            K = _K;
            int res = 0;
            for (int k = 1; k <= 26; k++) {
                map = new HashMap<>();
                x = 0;
                y = 0;
                for (int i = 0, j = 0; i < s.length(); i++) {
                    // add one char
                    add(s.charAt(i));
                    while (x > k) {
                        del(s.charAt(j++));
                    }
                    if (x == y) {
                        res = Math.max(res, i - j + 1);
                    }
                }
            }

            return res;
        }
    }
}
