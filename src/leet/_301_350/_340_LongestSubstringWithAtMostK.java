package leet._301_350;

import java.util.HashMap;
import java.util.Map;

public class _340_LongestSubstringWithAtMostK {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;

        for (int l = 0, r = 0; r < s.length(); r++) {
            map.put(chars[r], map.getOrDefault(chars[r], 0) + 1);

            while (l <= r && map.size() > k) {
                map.put(chars[l], map.get(chars[l]) - 1);
                if (map.get(chars[l]) == 0) {
                    map.remove(chars[l]);
                }
                l++;
            }

            if (map.size() <= k) {
                ans = Math.max(ans, r - l + 1);
            }
        }

        return ans;
    }
}
