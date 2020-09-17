package leet._51_100;

import java.util.HashMap;
import java.util.Map;

public class _76_Minimum_Window_Substring {
    //TODO
    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return "";
        }

        if (s.length() < t.length()) {
            return "";
        }

        char[] A = s.toCharArray();
        int len = A.length;

        // char -> freq. How many chars left to fill
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        String ans = "";
        int l = 0;
        // know if it matches all chars in t
        int matched = 0;
        for (int r = 0; r < len; r++) {
            // when have char need to match
            if (map.containsKey(A[r])) {
                if (map.get(A[r]) > 0) {
                    matched++;
                }
                map.put(A[r], map.get(A[r]) - 1);
            }

            // need shrink and update ans
            while (matched == t.length()) {
                String cur = s.substring(l, r + 1);
                // if it is "". ignore and also set to the cur
                if (ans.isEmpty() || ans.length() > cur.length()) {
                    ans = cur;
                }

                char lc = A[l];
                l++;

                if (map.containsKey(lc)) {
                    map.put(lc, map.get(lc) + 1);
                    if (map.get(lc) > 0) {
                        matched--;
                    }
                }
            }
        }

        return ans;
    }
}
